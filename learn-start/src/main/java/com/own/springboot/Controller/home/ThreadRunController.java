package com.own.springboot.Controller.home;

import com.own.springboot.Controller.home.AsyncTask.AsyncTask;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import com.own.springboot.biz.systemUser.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ThreadRunController {
    @Autowired
    AsyncTask asyncTask;

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping("/learn/thread/async")
    public  void  showTest()
    {
        //异步测试
        //asyncTask.task1();
        //同步测试
        this.task1sync();
    }

    public void task1sync(){
        ArrayList<SystemUser> userList = new ArrayList<SystemUser>();
        SystemUser user = new SystemUser();
        userList = systemUserService.selectList(user);
        for(int i=0;i<500;i++){
            System.out.println("AAA"+i);
        }
    }
}
