package com.own.springboot.Controller.home.AsyncTask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 只要要@EnableAsync就可以使用多线程。
 * 使用@Async就可以定义一个线程任务。
 * 通过spring给我们提供的ThreadPoolTaskExecutor就可以使用线程池。
 */
@Component
public class AsyncTask {

    @Async("myAsyncThreadPool")
    public void task1(){
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":运行次数="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async("myAsyncThreadPool")
    public void task2(){
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":运行次数="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async("myAsyncThreadPool")
    public Future<Boolean>  haveReturnValueTask(){

        System.out.println(Thread.currentThread().getName()+":开始！");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":结束！");
        return  new AsyncResult<>(true);
    }




}
