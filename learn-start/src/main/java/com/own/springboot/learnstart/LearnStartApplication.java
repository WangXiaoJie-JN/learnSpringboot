package com.own.springboot.learnstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LearnStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnStartApplication.class, args);
    }

}
