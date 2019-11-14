package com.own.springboot.biz.resources.dao;

import com.own.springboot.biz.resources.domain.Resources;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}