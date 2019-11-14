package com.own.springboot.Controller.home.schedualExecutorTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduledRunnableTask implements  Runnable{
    Logger logger = LoggerFactory.getLogger(ScheduledRunnableTask.class);
    @Override
    public void run() {

        DateTimeFormatter fomater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logger.info(Thread.currentThread().getName()+"-当前执行时间："+fomater.format(LocalDateTime.now()));
    }
}
