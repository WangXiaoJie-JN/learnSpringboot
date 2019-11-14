package com.own.springboot.thread.waitNotify;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Product {

    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    int n;
    // true:有值可取，false:需要放入新值
    boolean valueSet = false;

    synchronized  public void get(){
        if(!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info(Thread.currentThread().getName()+"-Get:"+n);
        valueSet = false;
        // 通知等待线程，放入新值
        notify();
    }


    synchronized public void put(int n){
        if(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = true;
        logger.info(Thread.currentThread().getName()+"-Put:"+n);
        notify();
    }
}
