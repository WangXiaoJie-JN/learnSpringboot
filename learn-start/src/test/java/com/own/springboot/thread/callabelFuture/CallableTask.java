package com.own.springboot.thread.callabelFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    private final Logger logger = LoggerFactory.getLogger(CallableTask.class);
    @Override
    public Integer call() throws Exception {

        logger.info("callable子任务在执行......");
        Integer sum = 0;
        for (int i = 0;i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}

class RunnableTask implements  Runnable{

    public volatile boolean keepRunning = true;

    private final Logger logger = LoggerFactory.getLogger(RunnableTask.class);
    @Override
    public void run() {

        Integer count = 0;
        logger.info("---------------runnable子线程开始了");
        while(keepRunning){
            logger.info("----------------runnable线程："+(++count));
            /*
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis()-time<1000){
            }
             */
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("---------------runnable子线程结束了");
    }
}
