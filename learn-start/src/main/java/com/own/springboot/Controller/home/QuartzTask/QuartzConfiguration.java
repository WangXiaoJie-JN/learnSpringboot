package com.own.springboot.Controller.home.QuartzTask;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Configuration
public class QuartzConfiguration {

    @Bean(name = "simpleJobDetail")
    public JobDetail simpleJobDetail(){
        // storeDurably() 即使没有Trigger关联时，也不需要删除该JobDetail
        return JobBuilder.newJob(JobTask.class).withIdentity("simplejobTask","simpleJobGroup").storeDurably().build();
    }

    // 把 jobDetail注册到trigger
    @Bean(name="simpleJobTrigger")
    public Trigger simpleJobTrigger(){

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        simpleScheduleBuilder.withIntervalInSeconds(30).repeatForever();

        return TriggerBuilder.newTrigger()
                .withIdentity("simplejobTrigger","simpleTriggerGroup")
                .withSchedule(simpleScheduleBuilder)
                .forJob(simpleJobDetail())
                .startNow()
                .build();

    }

    @Bean(name="cronJobDetail")
    public JobDetail cronJobDetail(){
        return JobBuilder.newJob(cronJobTask.class).withIdentity("cronJobDetail").storeDurably().build();
    }

    @Bean(name="cronTrigger")
    public Trigger cronTrigger(){

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ? 2019");
        return TriggerBuilder.newTrigger()
                .withIdentity("cronJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .forJob(cronJobDetail())
                .build();

    }
}
