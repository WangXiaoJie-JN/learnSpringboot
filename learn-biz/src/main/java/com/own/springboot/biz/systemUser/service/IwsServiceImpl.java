package com.own.springboot.biz.systemUser.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.own.springboot.biz.interfaces.IwsService;
import com.own.springboot.biz.systemUser.dao.ISystemUserDAO;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Service
@WebService
public class IwsServiceImpl implements IwsService {

    @Resource
    ISystemUserDAO systemUserDAO;

    @Override
    public ArrayList<SystemUser> getUserList(String userStr) {

        try{
            ObjectMapper mapper = new ObjectMapper();
            SystemUser user = mapper.readValue(userStr,SystemUser.class);
           // return systemUserDAO.selectList(user);
            ArrayList<SystemUser> userList = new ArrayList<SystemUser>();
            userList.add(user);
            return userList;

        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }


    }
}
