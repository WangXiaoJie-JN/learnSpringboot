package com.own.springboot.Controller.home.schedualAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并行执行JOB
 * 搭配那个@Scheduled
 */
@Configuration
public class SchedualConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.setScheduler(setTaskExecutors());
    }

    @Bean
    public Executor setTaskExecutors(){

        ExecutorService executorService = Executors.newScheduledThreadPool(3);
        return executorService;
    }
}
