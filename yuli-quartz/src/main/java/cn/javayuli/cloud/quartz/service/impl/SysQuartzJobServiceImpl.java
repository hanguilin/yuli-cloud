package cn.javayuli.cloud.quartz.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.cloud.common.core.constant.LocalDict;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.common.core.exception.CheckedException;
import cn.javayuli.cloud.quartz.entity.SysQuartzJob;
import cn.javayuli.cloud.quartz.mapper.SysQuartzJobMapper;
import cn.javayuli.cloud.quartz.service.SysQuartzJobService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: 定时任务业务接口实现类
 * @author: hanguilin
 * @createDate: 2021年01月28日
 * @version: 1.0
 */
@Service
public class SysQuartzJobServiceImpl extends ServiceImpl<SysQuartzJobMapper, SysQuartzJob> implements SysQuartzJobService {

    @Autowired
    private Scheduler scheduler;

    /**
     * trigger名前缀
     */
    private static final String TRIGGER_PREFIX = "trigger_";

    /**
     * 执行一次的任务名前缀
     */
    private static final String ONCE_PREFIX = "once_";

    /**
     * 保存数据
     *
     * @param sysQuartzJob 定时任务
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<SysQuartzJob> saveQuartz(SysQuartzJob sysQuartzJob) throws SchedulerException {
        SysQuartzJob existsJob = getOne(Wrappers.lambdaQuery(SysQuartzJob.class).eq(SysQuartzJob::getJobName, sysQuartzJob.getJobName()).eq(SysQuartzJob::getJobGroup, sysQuartzJob.getJobGroup()));
        if (existsJob != null) {
            return Rest.fail("请确保任务名+任务组的唯一性");
        }
        boolean res = save(sysQuartzJob);
        if (!res) {
            return Rest.fail("保存失败");
        }
        if (LocalDict.ENABLED.equals(sysQuartzJob.getEnabled())) {
            // 添加到定时任务
            addJob(sysQuartzJob.getJobName(), sysQuartzJob.getJobGroup(), sysQuartzJob.getCron(), sysQuartzJob.getTargetClass());
        }
        return Rest.success(sysQuartzJob);
    }

    /**
     * 更新数据
     *
     * @param sysQuartzJob 定时任务
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> updateQuartz(SysQuartzJob sysQuartzJob) throws SchedulerException, ClassNotFoundException {
        boolean res = updateById(sysQuartzJob);
        if (!res) {
            return Rest.fail("更新定时任务失败");
        }
        // 修改定时任务状态
        String enabled = sysQuartzJob.getEnabled();
        if (StrUtil.isNotBlank(enabled)) {
            // 查询数据库job
            SysQuartzJob job = getById(sysQuartzJob.getId());
            String jobName = job.getJobName();
            String jobGroup = job.getJobGroup();
            String cron = job.getCron();
            String targetClass = job.getTargetClass();
            JobKey jobKey = new JobKey(jobName, jobGroup);
            // 任务已经存在
            if (scheduler.checkExists(jobKey)) {
                // 删除旧任务
                removeJob(jobName, jobGroup);
            }
            // 启用任务
            if (LocalDict.ENABLED.equals(enabled)) {
                addJob(jobName, jobGroup, cron, targetClass);
            }
        }
        return Rest.success();
    }

    /**
     * 删除数据
     *
     * @param idList 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeQuartz(List<String> idList) throws SchedulerException {
        List<SysQuartzJob> sysQuartzJobs = listByIds(idList);
        for (SysQuartzJob sysQuartzJob : sysQuartzJobs) {
            removeJob(sysQuartzJob.getJobName(), sysQuartzJob.getJobGroup());
        }
        removeByIds(idList);
    }

    /**
     * 执行一次
     *
     * @param id 任务id
     * @return
     */
    @Override
    public Rest<Boolean> once(String id) throws SchedulerException {
        SysQuartzJob sysQuartzJob = getById(id);
        if (sysQuartzJob == null) {
            return Rest.fail("无数据");
        }
        String jobName = ONCE_PREFIX + sysQuartzJob.getJobName();
        String jobGroup = ONCE_PREFIX + sysQuartzJob.getJobGroup();
        String targetClass = sysQuartzJob.getTargetClass();
        JobKey jobKey = new JobKey(jobName, jobGroup);
        // 如果以前存在，则删除
        if (scheduler.checkExists(jobKey)) {
            removeJob(jobName, jobGroup);
        }
        Class clazz;
        try {
            clazz = Class.forName(targetClass);
        } catch (ClassNotFoundException e) {
            throw new CheckedException(String.format("目标类%s不存在", targetClass));
        }
        JobDetail jobDetail = JobBuilder.newJob(clazz).build();
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity(TRIGGER_PREFIX + jobName, TRIGGER_PREFIX + jobGroup)
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withRepeatCount(0)
                )
                .build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        // 执行完成后删除job
        removeJob(jobName, jobGroup);
        return Rest.success();
    }

    /**
     * 添加到定时任务
     *
     * @param jobName 任务名
     * @param jobGroup 任务组
     * @param cron 定时表达式
     * @param targetClass 目标类，必须集成Job，实现execute方法
     * @throws SchedulerException
     * @throws ClassNotFoundException
     */
    private void addJob(String jobName, String jobGroup, String cron, String targetClass) throws SchedulerException {
        Class clazz;
        try {
            clazz = Class.forName(targetClass);
        } catch (ClassNotFoundException e) {
            throw new CheckedException(String.format("目标类%s不存在", targetClass));
        }
        JobKey jobKey = new JobKey(jobName, jobGroup);
        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
        }
        JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) clazz).withIdentity(jobKey)
                .build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(TRIGGER_PREFIX + jobName, TRIGGER_PREFIX + jobGroup)
                .withSchedule(cronScheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * 暂停定时任务
     *
     * @param jobName 任务名
     * @param jobGroup 任务组
     * @throws SchedulerException
     */
    private void pauseJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复定时任务
     *
     * @param jobName 任务名
     * @param jobGroup 任务组
     * @throws SchedulerException
     */
    private void resumeJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除定时任务
     *
     * @param jobName 任务名
     * @param jobGroup 任务组
     * @throws SchedulerException
     */
    private void removeJob(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(TRIGGER_PREFIX + jobName, TRIGGER_PREFIX + jobGroup);
        Trigger trigger =  scheduler.getTrigger(triggerKey);
        if (trigger == null) {
            return;
        }
        // 停止触发器
        scheduler.pauseTrigger(triggerKey);
        // 移除触发器
        scheduler.unscheduleJob(triggerKey);
        // 删除任务
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        scheduler.deleteJob(jobKey);
    }
}
