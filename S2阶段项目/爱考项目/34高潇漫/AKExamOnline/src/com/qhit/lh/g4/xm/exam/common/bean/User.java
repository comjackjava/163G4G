package com.qhit.lh.g4.xm.exam.common.bean;

public class User implements java.io.Serializable {

	private String name;
	private String pwd;
	private Integer role;


	public User() {
	}

	public User(String pwd, Integer role) {
		this.pwd = pwd;
		this.role = role;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}