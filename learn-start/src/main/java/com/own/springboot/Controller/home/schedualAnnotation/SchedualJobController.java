package com.own.springboot.Controller.home.schedualAnnotation;

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
   // @Scheduled(cron = "0/30 * * * * ?")
    public void taskOne(){

        logger.info("now time="+new Date());
        for(int i=0;i<10;i++){
            logger.info("scheduledTask-"+i);
        }
    }

    //@Scheduled(cron = "0/30 * * * * ?")
    public void taskTwo(){
        logger.info("------------------now is "+new Date());
        for(int i=0;i<10;i++){
            logger.info("---scheduledTask2-"+i);
        }
    }

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void taskOneCopy(){
        logger.info("--------3-----------now time="+new Date());
    }
}
