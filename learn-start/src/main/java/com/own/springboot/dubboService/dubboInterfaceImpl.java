package com.own.springboot.dubboService;

import com.alibaba.dubbo.config.annotation.Service;
import com.own.springboot.biz.interfaces.dubboInterface;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import com.own.springboot.biz.systemUser.service.SystemUserService;
import com.own.springboot.common.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Service(protocol = {"dubbo","rest"},validation = "true",timeout = 3000,version = "1.0")
@Path("learnService")
public class dubboInterfaceImpl implements dubboInterface {

    @Autowired
    private SystemUserService systemUserService;

    @Path("user/list")
    public BaseResponse getLearnUserMsg(@QueryParam("userName") String userName) {

        try{
            SystemUser user = new SystemUser();
            user.setUserName(userName);
            List<SystemUser> list =systemUserService.selectList(user);
            BaseResponse response = new BaseResponse(1,"SUCCESS",list);

            return response;
        }catch(Exception ex){
            ex.printStackTrace();
            BaseResponse response = new BaseResponse(0,"ERROR",null);
            return response;

        }

    }

    @Path("rest")
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public  BaseResponse pushRestUserMsgServer(SystemUser user){
        try{
            List<SystemUser> list =systemUserService.selectList(user);
            BaseResponse response = new BaseResponse(1,"SUCCESS",list);
            return response;
        }catch(Exception ex){
            ex.printStackTrace();
            BaseResponse response = new BaseResponse(0,"ERROR",null);
            return response;

        }
    }
}
