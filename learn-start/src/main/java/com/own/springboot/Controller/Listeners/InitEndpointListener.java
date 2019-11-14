package com.own.springboot.Controller.Listeners;
import com.own.springboot.biz.systemUser.service.IwsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.xml.ws.Endpoint;

@Component
public class InitEndpointListener implements ApplicationListener {

    @Autowired
    IwsServiceImpl iwsServiceImpl;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        /*
        System.err.println("in initEndpointListener 发布IwsServiceImpl");
//http://127.0.0.1:8989/ws/userList2?wsdl
        //webservice 发布服务地址
        String address = "http://localhost:8989/ws/userList2";
        Endpoint.publish(address,iwsServiceImpl);
        System.err.println("in initEndpointListener使用WebServicePublishListener发布webservice成功!");
    */
    }


    /*
       public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 将 ApplicationContext 转化为 WebApplicationContext
        WebApplicationContext webApplicationContext =
            (WebApplicationContext)contextRefreshedEvent.getApplicationContext();
        // 从 webApplicationContext 中获取  servletContext
        ServletContext servletContext = webApplicationContext.getServletContext();
        // servletContext设置值
        servletContext.setAttribute("key", "value");
        }
    */
}
