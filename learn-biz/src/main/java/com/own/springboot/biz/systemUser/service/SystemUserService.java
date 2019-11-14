package com.own.springboot.biz.systemUser.service;

import com.own.springboot.biz.systemUser.dao.ISystemUserDAO;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service
@Transactional(rollbackFor = {SQLException.class},propagation = Propagation.REQUIRED,readOnly = false)
public class SystemUserService{

    @Autowired
    private ISystemUserDAO systemUserDAO;

    /**
     * cacheable相同参数查询缓存中的数据
     * cacheput查询数据库
     * caching(cacheable={@Cacheable(),@Cacheable},put={@Cacheput()},evict={@CacheEvict()})
     * @param systemUser
     * @return
     */
    //@Cacheable(value = "userCache")
    //@CachePut(value = "userCache") 每次都会查询数据
    @Caching(cacheable = {@Cacheable(value="userCache")})
    public ArrayList<SystemUser> selectList(SystemUser systemUser) {

        return systemUserDAO.selectList(systemUser);
    }

    @CacheEvict(value="userCache",allEntries = false)
    public void deleteUserById(String id){

        systemUserDAO.deleteById(id);
    }
}