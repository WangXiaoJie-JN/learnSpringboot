package com.own.springboot.biz.systemUser.dao;

import com.own.springboot.biz.systemUser.domain.SystemUser;
import com.own.springboot.commonEntity.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ISystemUserDAO {

    ArrayList<SystemUser> selectList(SystemUser systemUser);

    void deleteById(@Param("id") String id);
}
