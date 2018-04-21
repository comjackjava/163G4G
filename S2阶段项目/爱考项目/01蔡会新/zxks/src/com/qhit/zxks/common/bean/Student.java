package com.qhit.zxks.common.bean;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String sname;
	private String sex;
	private Integer age;
	private Integer mid;
	private Integer cid;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sname, String sex, String username, String password) {
		this.sname = sname;
		this.sex = sex;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Student(String sname, String sex, Integer age, Integer mid,
			Integer cid, String username, String password) {
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.mid = mid;
		this.cid = cid;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}