package com.qhit.zxks.common.bean;

public class Major {
	private int mid;
	private String mname;
	
	public Major() {
		// TODO Auto-generated constructor stub
	}
	public Major(int mid, String mname) {
		this.mid = mid;
		this.mname = mname;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
