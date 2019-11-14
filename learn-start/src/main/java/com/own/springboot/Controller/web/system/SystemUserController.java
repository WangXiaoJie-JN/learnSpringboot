package com.own.springboot.Controller.web.system;

import com.own.springboot.biz.systemUser.domain.SystemUser;
import com.own.springboot.biz.systemUser.service.SystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class SystemUserController {

    Logger logger = LoggerFactory.getLogger(SystemUserController.class);
    private String prefix = "web/system";
    @Autowired
    SystemUserService systemUserService;

    /**
     * 查看所有用户
     * @param model
     * @return
     */
    @RequestMapping(value = "/userpage")
    public String userPage(Model model){

        ArrayList<SystemUser> userList = new ArrayList<SystemUser>();
        SystemUser user = new SystemUser();
        userList = systemUserService.selectList(user);
        model.addAttribute("userList",userList);
        return prefix+"/userPage";
    }

    @RequestMapping(value="/deleteUser")
    public void deleteUserById() {
        String id = "1";
        systemUserService.deleteUserById(id);
    }

    /**
     * 可以清除指定缓存上的内容
     * allEntries:是否全部清除
     * BeforeInvocation:是否在方法执行之前清除缓存，默认false即在方法执行后清除缓存
     */
    @RequestMapping(value="/clearCache")
    @CacheEvict(value = "userCache",allEntries = true,beforeInvocation = true)
    public void clearCache(){
        System.out.println("clear cache!");
    }

}
