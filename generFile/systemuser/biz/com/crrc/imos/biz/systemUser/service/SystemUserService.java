/*
 * Powered By [siufung]
 * Web Site: http://siufung.net
 * Since 2013 - 2016
 */
package com.crrc.imos.biz.systemUser.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import com.crrc.imos.biz.systemUser.domain.SystemUser;
import com.crrc.imos.biz.systemUser.dao.ISystemUserDAO;
import com.crrc.imos.plugins.security.AuthUtils;
import com.crrc.imos.plugins.instance.State;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import io.siufung.boot.mybatis.support.ServiceImpl;
import io.siufung.boot.mybatis.support.paging.JqPage;
import io.siufung.boot.mybatis.support.PageEntity;
import io.siufung.boot.mybatis.support.plugins.pagination.Pagination;

import org.apache.commons.lang3.StringUtils;
/**
 * ServiceImpl 
 * @author chenjianfeng
 * @Email qd_chenjianfeng@163.com
 * @Date 2018-10-25 10:10
 * @version 2018-10-25 10:10 v1.0
 */
 
@Service("Service")
@Transactional(readOnly = true)
public class SystemUserService extends ServiceImpl<ISystemUserDAO,SystemUser> {
	
	/**
	 * 分页 重写
	* @Title: queryPage
	* @param entity
	* @param pageEntity
	* @return Page<SystemMenu>    返回类型
	* @throws
	 */
	@Override
	public JqPage<SystemUser> queryForPage(SystemUser entity,PageEntity pageEntity){
		// TODO Auto-generated method stub
		Pagination<SystemUser> pager = super.getPage(entity, pageEntity);
		return new JqPage<SystemUser>(pager.getPageIndex(),pager.getPageSize(),
				pager.getRowCount(),pager.getRecords());
	}
	
	/**
	 * 插入或者更新 重写
	 * @param entity 插入或者更新数据 
	 */
	@Override
	@Transactional(readOnly = false)
	public void insertOrUpdate(SystemUser entity) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(entity.getId())){
			entity.setCreateDate(new Date());
			entity.setDelFlag(State.NORMAL);
			sqlTemplate.insert(entity);
		} else {
			entity.setUpdateBy(AuthUtils.getAuthUser().getName());
			entity.setUpdateDate(new Date());
			sqlTemplate.update(entity);
		}
	}
}