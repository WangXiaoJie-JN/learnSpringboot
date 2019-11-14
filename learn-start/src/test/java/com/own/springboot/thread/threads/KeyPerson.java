package com.own.springboot.thread.threads;

public class KeyPerson extends  Thread {

    KeyPerson(String name){
        super(name);
    }

    @Override
    public  void run(){

        System.out.println(Thread.currentThread().getName()+":开始战斗...");
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+":左突围，右突围...");
        }
        System.out.println(Thread.currentThread().getName()+":结束战斗...");
    }
}
