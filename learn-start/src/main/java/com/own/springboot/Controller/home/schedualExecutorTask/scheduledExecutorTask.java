package com.own.springboot.Controller.home.schedualExecutorTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用scheduledExecutorService进行任务调度
 */
public class scheduledExecutorTask {
    public static void main(String[] args) {

        // Executors.newScheduledThreadPool实现的是ScheduledThreadPoolExecutor
        // 实现ScheduledExecutorService
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        // 参数：1、任务体 2、首次执行的延时时间 3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(new ScheduledRunnableTask(), 0, 3, TimeUnit.SECONDS);

    }

}
