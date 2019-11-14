package com.own.springboot.thread.threads;

/**
 * 作战舞台
 */
public class Stage extends  Thread{

    Stage(String name){
        super(name);
    }

    @Override
    public void  run(){

        System.out.println(getName()+"：剧目开始：");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋朝军队");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"起义军队");

        armyOfSuiDynasty.start();
        armyOfRevolt.start();
        // 主线程暂停
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        // 第一次演示的时候用
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */
        // 第二次演示的时候
        System.out.println(getName()+"：关键人物出现...,老程来了......");
        KeyPerson keyPerson = new KeyPerson("程咬金");
        //停战
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;
        System.out.println(getName()+"：程咬金开始战斗......");
        // 执行隋军和起义军停战动作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        keyPerson.start();
        // 主线程等待keyPerson执行完毕，再执行
        try {
            keyPerson.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName()+":程咬金表演完毕...,谢幕！");

    }

    public static  void main(String[] args){
        new Stage("主进程").start();
    }
}
