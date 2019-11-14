
package com.own.springboot.biz.systemUser.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;



@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class SystemUser implements Serializable{

	private int id;
	@Length(min=1, max=50,message="长度必须介于1~50之间")
	private String userName;

	@Length(min=1, max=255,message="长度必须介于1~255之间")
	private String userPwd;

	@Length(min=1, max=255,message="长度必须介于1~255之间")
	private String userPlainPwd; 
	
	private String userPhone;
	
	@Length(max=255,message="长度不能超过255位字符")
	private String userWxOpenid; 
	
	@Length(max=255,message="长度不能超过255位字符")
	private String userEmail; 
	
	@Length(max=1,message="长度不能超过1位字符")
	private String userSex; 
	
	@Length(max=255,message="长度不能超过255位字符")
	private String pinyin;

	private String delFlag;

	private String createBy;
	private Date createDate;

	private String updateBy;
	private Date updateDate;
	private String remarks;
	private int bak1;
	private String bak2;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPlainPwd() {
		return userPlainPwd;
	}

	public void setUserPlainPwd(String userPlainPwd) {
		this.userPlainPwd = userPlainPwd;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserWxOpenid() {
		return userWxOpenid;
	}

	public void setUserWxOpenid(String userWxOpenid) {
		this.userWxOpenid = userWxOpenid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getBak1() {
		return bak1;
	}

	public void setBak1(int bak1) {
		this.bak1 = bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

