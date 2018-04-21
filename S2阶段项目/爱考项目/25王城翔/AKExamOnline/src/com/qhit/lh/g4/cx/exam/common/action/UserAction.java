/**
 * 
 */
package com.qhit.lh.g4.cx.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.jay.exam.common.bean.User;
import com.qhit.lh.g4.jay.exam.common.service.UserService;
import com.qhit.lh.g4.jay.exam.common.service.UserServiceImpl;

/**
 * @author admin
 * 2017�?2�?7�?
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	/**
	 * @return
	 * 登录
	 */
	public String login(){
		user = userService.login(user);
		if(user != null){
			//登录成功
			System.out.println(user.toString());
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登录失败！用户名密码错误!");
			return "loginFail";
		}
	}
	
	/**
	 * @return
	 * �?��
	 */
	public String logout(){
		//获取session对象，并�?��
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
