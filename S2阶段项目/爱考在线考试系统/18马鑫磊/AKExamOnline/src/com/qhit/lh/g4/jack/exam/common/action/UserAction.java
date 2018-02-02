package com.qhit.lh.g4.jack.exam.common.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.jack.exam.common.bean.User;
import com.qhit.lh.g4.jack.exam.common.dao.Userdao;
import com.qhit.lh.g4.jack.exam.common.dao.impl.UserdaoImpl;

public class UserAction  extends ActionSupport{
	private User user;
	private Userdao userdao =new UserdaoImpl();
public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Userdao getUserdao() {
		return userdao;
	}
	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}

	public String login(){
		User users =userdao.login(user);
		if(users!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user", users);
			return "loginsuccess";
		}else{
			super.addActionError("账户名或密码错误");
			return "loginfail";
		}
		
	}
	
}
