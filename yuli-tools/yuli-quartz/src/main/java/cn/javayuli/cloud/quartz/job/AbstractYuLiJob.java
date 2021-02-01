package cn.javayuli.cloud.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: hanguilin
 * @createDate: 2021/1/29
 * @version: 1.0
 */
public abstract class AbstractYuLiJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractYuLiJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("================");
        run(jobExecutionContext);
        LOGGER.info("================");
    }

    /**
     * 执行防范
     *
     * @param jobExecutionContext
     */
    public abstract void run(JobExecutionContext jobExecutionContext);
}
