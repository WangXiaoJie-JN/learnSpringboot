package com.own.springboot.thread.callabelFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class ExecutorTask {

    static Logger logger = LoggerFactory.getLogger(ExecutorTask.class);

    public static void main1(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTask callableTask = new CallableTask();
        Future<Integer> fuTrue = executor.submit(callableTask);
        executor.shutdown();

        // 主线程让步
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("正在执行主线程");

        try {
            Integer result = fuTrue.get();
            logger.info("callable线程返回的结果是："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("结束");

    }

    public static void main2(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTask callableTask = new CallableTask();
        //Future<Integer> fuTrue = executor.submit(callableTask);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableTask);
        executor.submit(futureTask);
        executor.shutdown();

        // 主线程让步
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("正在执行主线程");

        try {
            Integer result = futureTask.get();
            logger.info("callable线程返回的结果是："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("结束");

    }

    public static void main(String[] args){

        ExecutorService executors = Executors.newCachedThreadPool();
        RunnableTask runnableTask = new RunnableTask();
        // 1
        //FutureTask<?> futureTask = new FutureTask(runnableTask,null);
        //executors.submit(futureTask);
        // 2
        //Future<?> futureTask = executors.submit(runnableTask);
        //executors.shutdown();
        // 3
        executors.execute(runnableTask);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("主线程运行");
        // 相当于当用stop ,不能使线程停止
        //futureTask.cancel(true);
        runnableTask.keepRunning = false;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("结束！");

    }
}
