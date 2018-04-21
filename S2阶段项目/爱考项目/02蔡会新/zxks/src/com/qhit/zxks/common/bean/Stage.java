package com.qhit.zxks.common.bean;

public class Stage {
	private int sid;
	private String sname;
	
	public Stage() {
		// TODO Auto-generated constructor stub
	}
	public Stage(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
