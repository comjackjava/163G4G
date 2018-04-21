package com.qhit.lh.g4.perfact.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.perfact.exam.common.bean.Users;
import com.qhit.lh.g4.perfact.exam.common.service.UserService;
import com.qhit.lh.g4.perfact.exam.common.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	private Users user;

	public String login(){
		user = userService.Login(user);
		if(user != null){
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登陆失败！用户名或密码错误！");
			return "loginFail";
		}
	}
	
	//退出登录
	public String loginOut() {
		
		ServletActionContext.getRequest().getSession().invalidate();
		return "loginout";
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	

}
