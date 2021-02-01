package cn.javayuli.cloud.quartz.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.quartz.entity.SysQuartzJob;
import com.baomidou.mybatisplus.extension.service.IService;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @description: 定时任务业务接口
 * @author: hanguilin
 * @createDate: 2021年01月28日
 * @version: 1.0
 */
public interface SysQuartzJobService extends IService<SysQuartzJob> {

    /**
     * 保存数据
     *
     * @param sysQuartzJob 定时任务
     * @return
     */
    Rest<SysQuartzJob> saveQuartz(SysQuartzJob sysQuartzJob) throws ClassNotFoundException, SchedulerException;

    /**
     * 更新数据
     *
     * @param sysQuartzJob 定时任务
     * @return
     */
    Rest<Boolean> updateQuartz(SysQuartzJob sysQuartzJob) throws SchedulerException, ClassNotFoundException;

    /**
     * 删除数据
     *
     * @param idList 主键id
     * @return
     */
    void removeQuartz(List<String> idList) throws SchedulerException;

    /**
     * 执行一次
     *
     * @param id 任务id
     * @return
     */
    Rest<Boolean> once(String id) throws SchedulerException;
}
