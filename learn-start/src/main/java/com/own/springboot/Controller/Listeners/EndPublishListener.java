package com.own.springboot.Controller.Listeners;

import com.own.springboot.biz.systemUser.service.IwsServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

@WebListener
public class EndPublishListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //webservice 发布服务地址
        String address = "http://localhost:8989/ws/userList";
        Endpoint.publish(address, IwsServiceImpl.class);
        System.err.println("使用WebServicePublishListener发布webservice成功!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
