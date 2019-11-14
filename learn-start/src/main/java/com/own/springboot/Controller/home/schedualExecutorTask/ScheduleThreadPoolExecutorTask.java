package com.own.springboot.Controller.home.schedualExecutorTask;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExecutorTask {

    ScheduledThreadPoolExecutor scheduledThreadPool = new ScheduledThreadPoolExecutor(2);
    /*
    scheduled.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {

        }
    }, 0, 40, TimeUnit.MILLISECONDS);//0表示首次执行任务的延迟时间，40表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
    */
}
