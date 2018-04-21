package com.qhit.zxks.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.zxks.common.bean.Student;
import com.qhit.zxks.common.bean.Teacher;
import com.qhit.zxks.user.bean.Account;
import com.qhit.zxks.user.dao.AccountDAO;
import com.qhit.zxks.user.service.UserService;

/**
 * @类名:UserAction 
 * @类描述:
 * @作者:王东方
 * @创建时间:2018-1-2 上午9:04:23
 * @版本:
 * 
 */
public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private int role;
	private String message;
	private UserService userService = new UserService();
	/**
	 * 登陆
	 * @return
	 */
	public String login(){
		Object o = userService.login(username, password, role);
		if(o!=null){		//登陆成功
			if(role==0){
				Account a = (Account)o;
				ActionContext.getContext().getSession().put("user", a);
			}else if(role==1){
				Teacher t = (Teacher)o; 
				ActionContext.getContext().getSession().put("user", t);
			}else if(role==2){
				Student s = (Student)o;
				ActionContext.getContext().getSession().put("user", s);
			}
			ActionContext.getContext().getSession().put("role", 1);
			return SUCCESS;
		}
		message = "用户名或者密码错误，请重新登陆";
		return LOGIN;
	}
	public String getMessage() {
		return message;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getRole() {
		return role;
	}
	
}
