package com.qhit.zxks.common.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.zxks.questionBank.bean.Question;

public class Course {
	private int cid;
	private String cname;
	private int sid;
	private int mid;
	private Major major;
	private Stage stage;
	private Set<Question> questions = new HashSet<Question>();
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
}
