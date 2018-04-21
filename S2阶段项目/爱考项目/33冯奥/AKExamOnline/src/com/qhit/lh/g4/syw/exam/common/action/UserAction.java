package com.qhit.lh.g4.syw.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.syw.exam.common.bean.User;
import com.qhit.lh.g4.syw.exam.common.service.UserService;
import com.qhit.lh.g4.syw.exam.common.service.UserServiceImpl;

public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	public String login(){
		user = userService.login(user);
		if (user != null) {
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登录失败！请重试。");
			return "loginFail";
		}
	
		
	}
	
	/**
	 * @return
	 * 退出
	 */
	public String logout(){
		//获取session对象并销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
		
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
