package com.own.springboot.Controller.home.QuartzTask;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 可以implements Job
 * 也可以extends QuartzJobBean
 * 也可以只是一个普通的bean
 * 只是在配置JobDetail的时候使用不同的类
 */
@DisallowConcurrentExecution
public class JobTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<60;i++){
            System.out.println("---simpleJob---"+Thread.currentThread().getName()+":循环次数："+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
