package com.own.springboot.Controller.home.blockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Productor implements Runnable{

    Logger logger = LoggerFactory.getLogger(Productor.class);
    volatile static AtomicInteger count = new AtomicInteger(0);
    volatile  boolean isRunning = true;
    ArrayBlockingQueue<String> queue;

    public Productor(ArrayBlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        logger.info("开始生产流程...");
        while (isRunning){

            try {
                logger.info("成产...");
                queue.put("product-count:"+count.incrementAndGet());

            } catch (InterruptedException e) {
                logger.error("成产失败，将"+count.get()+"放入队列失败");
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logger.info("退出生产流程！");
    }

    public void stop(){
        this.isRunning = false;
    }
}
