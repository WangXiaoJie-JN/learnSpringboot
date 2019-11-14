package com.own.springboot.biz.interfaces;

import com.own.springboot.biz.systemUser.domain.SystemUser;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public interface IwsService {

    @WebMethod
    ArrayList getUserList(String entity);
}
