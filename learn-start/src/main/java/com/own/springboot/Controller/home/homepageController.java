package com.own.springboot.Controller.home;

import com.own.springboot.common.BaseResponse;
import com.own.springboot.common.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/homepage")
@Slf4j
public class homepageController {
    private static final String prefix="/home";
    Logger logger = LoggerFactory.getLogger(homepageController.class);
    @RequestMapping
    @ResponseBody
    public String homepage(){
        return "hello";
    }

    @RequestMapping(value="/page")
    public String getFrontPage(){

        logger.info("this is info {}","message1");
        logger.info("this is info {}","message2");
        logger.info("this is info {}","message3");
        logger.info("this is info {}","message4");
        logger.error("this is info {}","message1");
        logger.error("this is info {}","message2");
        logger.warn("this is info {}","message1");
        logger.debug("this is info {}","message1");
        logger.debug("this is info {}","message2");
        return prefix+"/page";
    }



}
