package com.own.springboot.thread.threads;

/**
 * 军队进程
 * 模拟作战
 */
public class ArmyRunnable implements  Runnable {

    //可见性，保证keepRunning正确读写
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while(keepRunning){
            // 五连击
            for (int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+":第["+i+"]次发动攻击...");
                //让出处理器
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+":结束五连击...");
    }
}
