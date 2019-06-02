package com.own.springboot.learnstart.Controller.home.schedual;

import com.own.springboot.learnstart.Controller.home.homepageController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Slf4j
public class SchedualJobController {

    Logger logger = LoggerFactory.getLogger(SchedualJobController.class);

    /**
     * 串型执行JOB
     * 测试
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void taskOne(){
        logger.info("now time="+new Date());
    }

    @Scheduled(cron = "30 0/1 * * * ?")
    public void taskTwo(){
        logger.error("------------------now is "+new Date());
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void taskOneCopy(){
        logger.info("--------3-----------now time="+new Date());
    }
}
