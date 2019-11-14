package com.own.springboot;

import com.own.springboot.Controller.home.AsyncTask.AsyncTask;
import com.own.springboot.Controller.home.blockingQueue.Consumor;
import com.own.springboot.Controller.home.blockingQueue.Productor;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnStartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnnotinationTest {

    @Autowired
    private AsyncTask asyncTask;

    @Resource
    ThreadPoolTaskExecutor myAsyncThreadPool;


    /**
     * async方式实现多线程
     */
    @Test
    public void AysncTaskTest(){
        asyncTask.task1();
        asyncTask.task2();
    }

    @Test
    public void BlockingQueueTest(){

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        Productor productor1 = new Productor(queue);
        Productor productor2 = new Productor(queue);
        Consumor consumor = new Consumor(queue);

        myAsyncThreadPool.execute(productor1);
       // myAsyncThreadPool.execute(productor2);
        myAsyncThreadPool.execute(consumor);

        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productor1.stop();
        //productor2.stop();
        consumor.stop();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myAsyncThreadPool.shutdown();
    }




}
