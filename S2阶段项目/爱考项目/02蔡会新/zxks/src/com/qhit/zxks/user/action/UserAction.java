package com.qhit.zxks.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.zxks.common.bean.Student;
import com.qhit.zxks.common.bean.Teacher;
import com.qhit.zxks.user.bean.Account;
import com.qhit.zxks.user.dao.AccountDAO;
import com.qhit.zxks.user.service.UserService;

/**
 * @����:UserAction 
 * @������:
 * @����:������
 * @����ʱ��:2018-1-2 ����9:04:23
 * @�汾:
 * 
 */
public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private int role;
	private String message;
	private UserService userService = new UserService();
	/**
	 * ��½
	 * @return
	 */
	public String login(){
		Object o = userService.login(username, password, role);
		if(o!=null){		//��½�ɹ�
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
		message = "�û�������������������µ�½";
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
