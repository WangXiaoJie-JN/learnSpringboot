package com.own.springboot.thread.waitNotify;

public class MainDemo {

    public  static  void main(String[] args){
        Product product = new Product();
        Productor productor = new Productor(product);
        Customer customer = new Customer(product);

    }
}
