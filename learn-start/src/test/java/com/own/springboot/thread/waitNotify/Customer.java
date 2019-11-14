package com.own.springboot.thread.waitNotify;

public class Customer implements Runnable{

    Product product;
    Customer(Product product){
        this.product = product;
        new Thread(this,"Customer").start();
    }
    @Override
    public void run() {
        for(int i = 0; i <5; i++){
            product.get();
        }
    }
}
