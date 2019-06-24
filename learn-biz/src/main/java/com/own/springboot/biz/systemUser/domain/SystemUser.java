
package com.own.springboot.biz.systemUser.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class SystemUser{
	 
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

