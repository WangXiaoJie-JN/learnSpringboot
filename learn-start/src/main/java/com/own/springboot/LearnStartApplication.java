package com.own.springboot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = "com.own.springboot.biz.*.dao")
@ImportResource(value={"classpath:spring/spring-dubbo.xml"})
public class LearnStartApplication {
    /**
     * 设置项目时区
     */
    @PostConstruct
    void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"));
    }

    public static void main(String[] args) {

        //System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(LearnStartApplication.class, args);
    }

}
