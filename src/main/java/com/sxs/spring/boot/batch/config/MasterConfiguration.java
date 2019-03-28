package com.sxs.spring.boot.batch.config;
import com.sxs.spring.boot.batch.support.BatchIncrementer;
import com.sxs.spring.boot.batch.support.JobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * @ClassName: MasterConfiguration
 * @Description: Master节点，派发分片任务到从节点
 * @Author: 尚先生
 * @CreateDate: 2019/3/12
 * @Version: 1.0
 */
@Configuration
public class MasterConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Profile({"master", "mixed"})
    @Bean
    public Job job(@Qualifier("masterStep") Step masterStep) {
        return jobBuilderFactory.get("endOfDayjob")
                .start(masterStep)
                .incrementer(new BatchIncrementer())
                .listener(new JobListener())
                .build();
    }

    @Bean("masterStep")
    public Step masterStep(@Qualifier("slaveStep") Step slaveStep,
                           PartitionHandler partitionHandler,
                           DataSource dataSource) {
        return stepBuilderFactory.get("masterStep")
                .partitioner(slaveStep.getName(), new ColumnRangePartitioner(dataSource))
                .step(slaveStep)
                .partitionHandler(partitionHandler)
                .build();
    }
}
