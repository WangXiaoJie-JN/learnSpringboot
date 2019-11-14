package com.own.springboot.Controller.home.QuartzTask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class cronJobTask implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<60;i++){
            System.out.println("活跃的线程数："+Thread.activeCount()+"|"+Thread.currentThread().getName()+":循环次数："+i);
            Thread.yield();
        }
    }
}
