package com.own.springboot.Controller.home.AsyncTask;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@Data
@EnableAsync
public class AsyncTaskConfig {

    @Value("${thread.pool.corePoolSize}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${thread.pool.queueCapicity}")
    private int queueCapicity;

    /**
     * 自定义线程池，结合@Async("beanname") ;@Bean(name="beanname")
     * 或者@Async 和@Bean不加name
     * @return
     */
    @Bean(name="myAsyncThreadPool")
    public Executor taskExecutor(){

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadNamePrefix("thread_pool_taskExecutor_");
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        //调度器shutdown被调用时，等待正在执行的任务完成
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //当线程池超过容纳量，又有新任务进来时的拒绝策略。
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setQueueCapacity(queueCapicity);
        //该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，
        // 以确保应用最后能够被关闭，而不是阻塞住。
        //若shutdown后的60秒内正在执行的任务没结束，强制结束
        taskExecutor.setKeepAliveSeconds(120);
        taskExecutor.initialize();
        return taskExecutor;
    }

}
