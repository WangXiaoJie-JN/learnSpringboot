package com.own.springboot.Controller.home.blockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumor implements Runnable {

    ArrayBlockingQueue<String> queue;
    volatile  boolean isRunnable = true;
    Logger logger = LoggerFactory.getLogger(Consumor.class);
    //AtomicInteger count = new AtomicInteger(0);

    public Consumor(ArrayBlockingQueue queue){
      this.queue = queue;
    }

    @Override
    public void run() {

        while(isRunnable){
            try {
                logger.info("正在消费...");
                String countStr = queue.poll(2, TimeUnit.SECONDS);

            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.info("正在消费Error：");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("消费结束！");
    }

    public void stop(){
        this.isRunnable = false;
    }
}
