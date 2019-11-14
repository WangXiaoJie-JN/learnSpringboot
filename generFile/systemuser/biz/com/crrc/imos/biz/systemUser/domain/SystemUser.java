/*
 * Powered By [siufung]
 * Web Site: http://siufung.net
 * Since 2013 - 2018
 */
package com.crrc.imos.biz.systemUser.domain;

import java.util.Date;
import io.siufung.boot.mybatis.support.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * SystemUser
 * @author qd_chenzhaofeng@163.com
 * @version 2018-10-25 10:10 v1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class SystemUser extends BaseEntity<SystemUser> { 
	 
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message="不能为空!")
	@Length(min=1, max=50,message="长度必须介于1~50之间")
	private String userName; 
	
	@NotBlank(message="不能为空!")
	@Length(min=1, max=255,message="长度必须介于1~255之间")
	private String userPwd; 
	
	@NotBlank(message="不能为空!")
	@Length(min=1, max=255,message="长度必须介于1~255之间")
	private String userPlainPwd; 
	
	private Integer userPhone; 
	
	@Length(max=255,message="长度不能超过255位字符")
	private String userWxOpenid; 
	
	@Length(max=255,message="长度不能超过255位字符")
	private String userEmail; 
	
	@Length(max=1,message="长度不能超过1位字符")
	private String userSex; 
	
	@Length(max=255,message="长度不能超过255位字符")
	private String pinyin; 
	
	
}

