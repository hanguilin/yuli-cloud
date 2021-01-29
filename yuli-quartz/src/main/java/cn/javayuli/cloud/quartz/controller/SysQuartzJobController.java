package cn.javayuli.cloud.quartz.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.quartz.service.SysQuartzJobService;
import cn.javayuli.cloud.quartz.entity.SysQuartzJob;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 定时任务
 * @author: hanguilin
 * @createDate: 2021年01月28日
 * @version: 1.0
 */
@Api(description = "定时任务")
@RestController
@RequestMapping("/sysQuartzJob")
public class SysQuartzJobController {

    @Autowired
    private SysQuartzJobService sysQuartzJobService;

    /**
    * 详情数据
    *
    * @param id 主键id
    * @return
    */
    @ApiOperation("根据id查询定时任务")
    @PreAuthorize("hasAuthority('quartz:sysQuartzJob:info')")
    @GetMapping("/info/{id}")
    public Rest<SysQuartzJob> doInfo(@PathVariable("id") String id) {
        SysQuartzJob sysQuartzJob = sysQuartzJobService.getById(id);
        return sysQuartzJob != null ? Rest.success(sysQuartzJob) : Rest.fail("无数据");
    }

    /**
     * 保存数据
     *
     * @param sysQuartzJob 定时任务
     * @return
     */
    @ApiOperation("保存定时任务")
    @PreAuthorize("hasAuthority('quartz:sysQuartzJob:save')")
    @PostMapping("/save")
    public Rest<SysQuartzJob> doSave(@RequestBody SysQuartzJob sysQuartzJob) throws SchedulerException, ClassNotFoundException {
        return sysQuartzJobService.saveQuartz(sysQuartzJob);
    }

    /**
     * 更新数据
     *
     * @param sysQuartzJob 定时任务
     * @return
     */
    @ApiOperation("更新定时任务")
    @PreAuthorize("hasAuthority('quartz:sysQuartzJob:update')")
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysQuartzJob sysQuartzJob) throws SchedulerException, ClassNotFoundException {
        return sysQuartzJobService.updateQuartz(sysQuartzJob);
    }

    /**
    * 删除数据
    *
    * @param ids 主键id
    * @return
    */
    @ApiOperation("删除定时任务")
    @PreAuthorize("hasAuthority('quartz:sysQuartzJob:delete')")
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete(@RequestParam String ids) throws SchedulerException {
        List<String> idList = Splitter.on(",").splitToList(ids);
        sysQuartzJobService.removeQuartz(idList);
        return Rest.success("删除定时任务成功");
    }

    /**
     * 分页数据
     *
     * @param page 分页对象
     * @param sysQuartzJob 定时任务
     * @return
     */
    @ApiOperation("分页查询定时任务")
    @PreAuthorize("hasAuthority('quartz:sysQuartzJob:page')")
    @GetMapping("/page")
    public Rest<Page<SysQuartzJob>> doPage(Page page, SysQuartzJob sysQuartzJob) {
        return Rest.success(sysQuartzJobService.page(page, Wrappers.query(sysQuartzJob)));
    }

    /**
     * 执行一次
     *
     * @param id 任务id
     * @return
     */
    @ApiOperation("执行一次")
    @PreAuthorize("hasAuthority('quartz:sysQuartzJob:update')")
    @GetMapping("/once")
    public Rest<Boolean> doOnce(String id) throws SchedulerException {
        return sysQuartzJobService.once(id);
    }
}