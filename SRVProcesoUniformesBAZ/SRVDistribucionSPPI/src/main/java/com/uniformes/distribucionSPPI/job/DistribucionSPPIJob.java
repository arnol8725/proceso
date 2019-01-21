package com.uniformes.distribucionSPPI.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.uniformes.distribucionSPPI.config.ConfigSPPI;
import com.uniformes.distribucionSPPI.negocio.DsitribucionSPPINegocio;

@Component
@DisallowConcurrentExecution
public class DistribucionSPPIJob implements Job {

    @Autowired
    private DsitribucionSPPINegocio negocio;

    @Autowired
    private ConfigSPPI config;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            negocio.ejecuta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean(name = "distSPPIJob")
    public JobDetail sampleJob() {
        return JobBuilder.newJob(DistribucionSPPIJob.class)
                .withIdentity("job-sppi", "jobs-uniformes")
                .usingJobData("ID", "1")
                .storeDurably()
                .build();
    }

    @Bean(name = "triggerDistribucionSPPI")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("distSPPIJob") JobDetail detJob) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(detJob);
        factoryBean.setCronExpression(config.CRON_EXPRESSION_SPPI);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        return factoryBean;
    }

}
