package com.sxs.spring.boot.batch.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @ClassName: JobListener
 * @Description: job执行监听器
 * @Author: 尚先生
 * @CreateDate: 2019/3/20
 * @Version: 1.0
 */
public class JobListener implements JobExecutionListener {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public void beforeJob(JobExecution jobExecution) {
           logger.error("Job准备执行,JobName:[{}]",jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        logger.error("Job执行完毕,执行结果:[{}]",jobExecution.getExitStatus());
    }
}
