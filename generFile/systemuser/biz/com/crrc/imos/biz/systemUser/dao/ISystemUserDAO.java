/*
 * Powered By [siufung]
 * Web Site: http://siufung.net
 * Since 2013 - 2018
 */
package com.crrc.imos.biz.systemUser.dao;

import io.siufung.boot.mybatis.support.annotation.MyBatisDao;
import io.siufung.boot.mybatis.support.BaseMapper;
import com.crrc.imos.biz.systemUser.domain.SystemUser;

/**
 * SystemUserDAO
 * @author chenjianfeng
 * @Date 2018-10-25 10:10
 * @version 2018-10-25 10:10 v1.0
 */
@MyBatisDao
public interface ISystemUserDAO extends BaseMapper<SystemUser>{ 
	
}
