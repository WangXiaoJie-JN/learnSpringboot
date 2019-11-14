package com.own.springboot.thread.waitNotify;

public class Productor implements  Runnable {

    Product product;
    Productor(Product product){
        this.product = product;
        new Thread(this,"Productor").start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            product.put(i);
        }
    }
}
