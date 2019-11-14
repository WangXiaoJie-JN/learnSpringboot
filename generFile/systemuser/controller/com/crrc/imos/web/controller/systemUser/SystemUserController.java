/*
 * Powered By [siu-fung]
 * Web Site: http://siu-fung.net
 * Since 2013 - 2016
 */
package com.crrc.imos.web.controller.systemUser;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crrc.imos.config.BaseController;
import com.crrc.imos.biz.systemUser.domain.SystemUser;
import com.crrc.imos.biz.systemUser.service.SystemUserService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import io.siufung.boot.mybatis.support.paging.JqPage;
import io.siufung.boot.mybatis.support.PageEntity;
import com.crrc.imos.plugins.utils.ExecuteResult;
import com.crrc.imos.plugins.utils.MyValidator;


/**
 * SystemUserController
 * @author chenjianfeng
 * @email qd_chenjianfeng@163.com
 * @Date 2018-10-25 10:10
 * @version v1.0
 */
@Controller
@RequestMapping(value="/systemUser/systemUser")
public class SystemUserController extends BaseController { 
	
	
	private final static Logger logger = LoggerFactory.getLogger(SystemUserController.class);
	
	/**
	 * prefix
	 */
	private final static String prefix = "modules/systemUser/systemUser";
	
	@Autowired
	private SystemUserService systemUserService;
	
	
	/**
	 * 跳转展示页面
	 * @param request 
	 * @param response
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@GetMapping
    public String page(HttpServletRequest request, HttpServletResponse response, Model model) {
		return prefix + "/page";
    }
	
	/**
	 * 跳转表单页面
	 * @param request
	 * @param response
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@GetMapping(value="/form/{id}")
    public String form(HttpServletRequest request, HttpServletResponse response, Model model,
    		@PathVariable("id") String id ) {
		return prefix + "/form";
    }
	
	/**
	 * 跳转表单新增页面
	 * @param request
	 * @param response
	 */
	@RequiresPermissions({"systemUser_systemUser_add"})
	@GetMapping(value="/add")
    public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
		return prefix + "/add";
    }
	
	/**
	 * 跳转表单编辑页面
	 * @param request
	 * @param response
	 * @param id 主键
	 */
	@RequiresPermissions({"systemUser_systemUser_edit"})
	@GetMapping(value="/edit/{id}")
    public String edit(HttpServletRequest request, HttpServletResponse response, Model model,
    		@PathVariable("id") String id ) {
		SystemUser systemUser = null;
		if(!StringUtils.isBlank(id)){
			systemUser = systemUserService.selectById(id);
			model.addAttribute("systemUser",systemUser);
		} else {
			model.addAttribute("systemUser",systemUser);	
		}
		return prefix + "/edit";
    }
	
	/**
	 * 跳转详细页面
	 * @param request
	 * @param response
	 * @param id 主键
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@GetMapping(value="/preview/{id}")
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model,
    		@PathVariable("id") String id ) {
		SystemUser systemUser = null;
		if(!StringUtils.isBlank(id)){
			systemUser = systemUserService.selectById(id);
			model.addAttribute("systemUser",systemUser);
		} else {
			model.addAttribute("systemUser",systemUser);	
		}
		return prefix + "/preview";
    }
	
	/**
	 * 跳转弹窗
	 * @param request
	 * @param response
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@GetMapping(value="/dialog")
    public String dialog(HttpServletRequest request, HttpServletResponse response, Model model) {
		return prefix + "/dialog";
    }
	
	/**
	 * 获得对象信息通过id
	 * @param request
	 * @param response
	 * @param id 主键
	 * @return SystemUser
	 * */
	@RequiresPermissions({"systemUser_systemUser"})
	@ResponseBody
	@PostMapping(value="/selectById/{id}")
	public SystemUser selectById(HttpServletRequest request, HttpServletResponse response, 
	    	@PathVariable("id") String id ) {
		SystemUser systemUser=null;
		if(!StringUtils.isBlank(id)){
			systemUser = systemUserService.selectById(id);
		}	
		return systemUser;
	}
	
	/**
	 * 获得对象信息通过对象特征
	 * @param request
	 * @param response
	 * @param systemUser
	 * @return SystemUser
	 * */
	@RequiresPermissions({"systemUser_systemUser"})
	@ResponseBody
	@PostMapping(value="/selectOne")
	public SystemUser selectOne(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute SystemUser systemUser ) {
		if(systemUser != null){
			systemUser = systemUserService.selectOne(systemUser);
		}
		return systemUser;
	}
	
	/**
	 * 通过对象特征获取对象列表
	* @param request
	* @param response
	* @param model  
	* @return List<SystemUser>   
	* @throws
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@ResponseBody
	@PostMapping(value="/selectList")
	public List<SystemUser> selectList(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute SystemUser systemUser ) {
		return systemUserService.selectList(systemUser);
	}
	
	/**
	 * 通过对象特征获取对象列表数量
	* @param request
	* @param response
	* @param model  
	* @return long   
	* @throws
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@ResponseBody
	@PostMapping(value="/selectCount")
	public long selectCount(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute SystemUser systemUser ) {
		return systemUserService.selectCount(systemUser);
	}
	
	/**
	 * 分页
	 * @param systemUser 分页接收类参数
	 * @param pageEntity 分页参数
	 * @param request
	 * @return Page 分页
	 */
	@RequiresPermissions({"systemUser_systemUser"})
	@PostMapping(value = "/getPage")
	@ResponseBody
	public JqPage<SystemUser> getPage(HttpServletRequest request,
			@ModelAttribute SystemUser systemUser,
			@ModelAttribute PageEntity pageEntity) {
		return systemUserService.queryForPage(systemUser,pageEntity);
	}
	
	/**
	 * 删除对象 物理删除
	* @method: remove 
	* @param request
	* @param response
	* @param id
	* @return ExecuteResult<SystemUser>
	 */
	@RequiresPermissions({"systemUser_systemUser_delete"})
	@ResponseBody
	@PostMapping(value="/delete/{id}")
	public ExecuteResult<SystemUser> delete(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") String id ) {
		systemUserService.deleteById(id);
		return ExecuteResult.ok("删除成功");
	}
	
	/**
	 * 删除对象 逻辑删除
	* @method: remove 
	* @param request
	* @param response
	* @param id
	* @return ExecuteResult<SystemUser>
	 */
	@RequiresPermissions({"systemUser_systemUser_delete"})
	@ResponseBody
	@PostMapping(value="/remove/{id}")
	public ExecuteResult<SystemUser> remove(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") String id ) {
		SystemUser systemUser = new SystemUser();
		systemUser.setId(id);
		systemUser.setDelFlag("1");
		systemUserService.insertOrUpdate(systemUser);
		return ExecuteResult.ok("删除成功");
	}
	
	
	/**
	 * 更改状态
	* @method: changeStatus 
	* @param request
	* @param response
	* @param id
	* @return ExecuteResult<SystemUser>
	 */
	@RequiresPermissions({"systemUser_systemUser_status"})
	@ResponseBody
	@PostMapping(value="/changeStatus/{id}/{delFlag}")
	public ExecuteResult<SystemUser> changeStatus(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") String id ,@PathVariable("delFlag") String delFlag ) {
		SystemUser systemUser = new SystemUser();
		systemUser.setId(id);
		systemUser.setDelFlag(delFlag);
		systemUserService.insertOrUpdate(systemUser);
		return ExecuteResult.ok("状态更改成功");
	}
	
	

	/**
	 * 添加
	* @method: add 
	* @param request
	* @param response
	* @return ExecuteResult<SystemUser>
	 */
	@RequiresPermissions("systemUser_systemUser_add")
	@ResponseBody
	@PostMapping(value="/add")
	public ExecuteResult<SystemUser> add(HttpServletRequest request,
			@ModelAttribute SystemUser systemUser) {
		systemUser.setCreateBy(getUserId());
		String validateMessage = MyValidator.beanValidator(systemUser);
		if(StringUtils.isBlank(validateMessage)){
			systemUserService.insertOrUpdate(systemUser);
		} else {
			return ExecuteResult.fail("数据格式不正确,请更改后再提交:"+validateMessage);
		}
		return ExecuteResult.ok("提交信息成功");
	}
	
	/**
	 * 修改
	* @method: update 
	* @param request
	* @param response
	* @return Response<SystemUser>
	 */
	@RequiresPermissions("systemUser_systemUser_edit")
	@ResponseBody
	@PostMapping(value="/update")
	public ExecuteResult<SystemUser> update(HttpServletRequest request ,
			@ModelAttribute SystemUser systemUser) {
		if(!StringUtils.isBlank(systemUser.getId())){
			SystemUser systemUserTemp = systemUserService.selectById(systemUser.getId());
			BeanUtils.copyProperties(systemUser,systemUserTemp);
			systemUserService.insertOrUpdate(systemUserTemp);
			return ExecuteResult.ok("提交信息修改成功");
		} else {
			return ExecuteResult.fail("提交信息主键不能为空");
		}
		
	}
	
	/**
	 * 导出
	 */
	
	
}
