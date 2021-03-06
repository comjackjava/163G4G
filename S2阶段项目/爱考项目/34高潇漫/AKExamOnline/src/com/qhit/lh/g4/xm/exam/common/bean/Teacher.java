package com.qhit.lh.g4.xm.exam.common.bean;
public class Teacher implements java.io.Serializable {

	private String tid;
	private String tname;
	private String sex;
	private String birthday;
	private String education;
	private String tel;
	private String post;
	private String remarks;
	
	//单向1-1
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Teacher() {
	}

	public Teacher(String tname, String sex, String post) {
		this.tname = tname;
		this.sex = sex;
		this.post = post;
	}

	public Teacher(String tname, String sex, String birthday, String education,
			String tel, String post, String remarks) {
		this.tname = tname;
		this.sex = sex;
		this.birthday = birthday;
		this.education = education;
		this.tel = tel;
		this.post = post;
		this.remarks = remarks;
	}


	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}