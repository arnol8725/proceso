package com.uniformes.iptienda.job;

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

import com.uniformes.iptienda.config.ConfigIPTiendas;
import com.uniformes.iptienda.negocio.IPTiendasNegocio;

@Component
@DisallowConcurrentExecution
public class IPTiendasJob implements Job {

    @Autowired
    private IPTiendasNegocio negocio;

    @Autowired
    private ConfigIPTiendas config;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            negocio.ejecuta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean(name = "iPTiendasJob")
    public JobDetail sampleJob() {
        return JobBuilder.newJob(IPTiendasJob.class)
                .withIdentity("job-proc", "jobs-uniformes")
                .usingJobData("ID", "12")
                .storeDurably()
                .build();
    }

    @Bean(name = "triggerIPTiendas")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("iPTiendasJob") JobDetail detJob) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(detJob);
        factoryBean.setCronExpression(config.CRON_EXP_IP_TIENDAS);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        return factoryBean;
    }

}
