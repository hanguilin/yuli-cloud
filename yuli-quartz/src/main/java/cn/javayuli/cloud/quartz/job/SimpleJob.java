package cn.javayuli.cloud.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @description:
 * @author: hanguilin
 * @createDate: 2021/1/28
 * @version: 1.0
 */
public class SimpleJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LOGGER.info("job execute---" + new Date());
    }
}
