package com.qhit.zxks.questionBank.bean;

public class CourseQuestionVO {
	private int cid;
	private String cname;
	private long bss;
	private long jss;
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
	public long getBss() {
		return bss;
	}
	public void setBss(long bss) {
		this.bss = bss;
	}
	public long getJss() {
		return jss;
	}
	public void setJss(long jss) {
		this.jss = jss;
	}
	public CourseQuestionVO(int cid, String cname, long bss, long jss) {
		this.cid = cid;
		this.cname = cname;
		this.bss = bss;
		this.jss = jss;
	}
	
	public CourseQuestionVO() {
		// TODO Auto-generated constructor stub
	}
	public CourseQuestionVO(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	
}
