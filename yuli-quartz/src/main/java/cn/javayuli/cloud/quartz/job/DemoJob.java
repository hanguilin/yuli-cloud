package cn.javayuli.cloud.quartz.job;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: hanguilin
 * @createDate: 2021/1/29
 * @version: 1.0
 */
public class DemoJob extends AbstractYuLiJob{

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoJob.class);

    @Override
    public void run(JobExecutionContext jobExecutionContext) {
        LOGGER.info("执行定时任务");
    }
}
