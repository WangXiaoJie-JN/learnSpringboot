package com.own.springboot.thread;

public class Test extends  Thread {

    Integer count = 0;

    Test(String name){
        super(name);
    }

    public void  run(){
        while(count<200){
            System.out.println(getName()+":次数="+count);
            count += 1;
        }

    }

    public static void  main(String[] args){

        Test test = new Test("Test");
        test.start();
        TwoTest twoTest = new TwoTest("TwoThread");
        twoTest.start();

        System.err.println("线程的个数："+Thread.activeCount());
        try {
            test.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int l = 0; l < 200; l++){
            System.out.println(Thread.currentThread().getName()+":------"+l);
        }

    }
}

class TwoTest extends  Thread{

    Integer count = 0;

    TwoTest(String name){
        super(name);
    }
    public void  run(){

        while(count<200){
            System.out.println(getName()+":次数="+count);
            count += 1;
        }

    }

}
