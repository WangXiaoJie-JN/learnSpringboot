package com.own.springboot.thread.threadPool;

import com.own.springboot.LearnStartApplication;
import com.own.springboot.LearnStartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnStartApplication.class)
public class FourThreadPool {

    static Logger logger = LoggerFactory.getLogger(FourThreadPool.class);


    /**
     * 线程池为无限大，当执行当前任务时上一个任务已经完成，
     * 会复用执行上一个任务的线程，而不用每次新建线程
     */
    @Test
    public void cacheThreadRool(){
        // 1 newCacheThreadPool
        // Executors.newCacheThreadPool()：可缓存线程池，
        // 先查看池中有没有以前建立的线程，如果有，就直接使用。
        // 如果没有，就建一个新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    logger.info("正在执行----"+i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdownNow();

    }


    /**
     * Executors.newFixedThreadPool(int n)：
     * 创建一个可重用固定个数的线程池，以共享的无界队列方式来s运行这些线程。
     *
     * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
     */
    @Test
    public void fixedThreadPool(){

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<5;j++){
                        logger.info(Thread.currentThread().getName()+"：正在执行");
                    }

                }
            });
        }

    }

    /**
     * Executors.newScheduledThreadPool(int n)：
     * 创建一个定长线程池，支持定时及周期性任务执行
     * execute 延迟执行
     */
    @Test
    public void scheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
        System.out.println(Thread.currentThread().getName()+":时间="+
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));

           scheduledThreadPool.schedule(new Runnable() {
               public void run() {
                   System.out.println("延迟1秒执行");
               }
           }, 1, TimeUnit.SECONDS);

           scheduledThreadPool.shutdown();


    }

    /**
     * 固定周期加延迟
     */
    @Test
    public void scheduledThreadPool2(){
        //创建一个定长线程池，支持定时及周期性任务执行——定期执行
         ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
          //延迟1秒后每3秒执行一次

          ScheduledFuture<?> sf = scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
              public void run() {
                  logger.info("延迟1秒后每3秒执行一次");
              }
       }, 1, 3, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }

    /**
     * Executors.newSingleThreadExecutor()：
     * 创建一个单线程化的线程池，
     * 它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    @Test
    public void singleThreadPool(){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            logger.info("创建第几个："+i+"线程");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<5;j++){
                        logger.info(Thread.currentThread().getName()+"：正在执行j");
                    }
                }
            });
        }
    }


}
