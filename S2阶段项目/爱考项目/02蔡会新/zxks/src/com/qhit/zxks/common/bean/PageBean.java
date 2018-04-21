package com.qhit.zxks.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:PageBean 
 * @类描述:
 * @作者:王东方
 * @创建时间:2018-1-10 上午8:17:27
 * @版本:
 * 
 */
public class PageBean {
	private int p;	//当前页
	private int pageSize; //每页显示条数
	private int pageTotal;	//总页数
	private int count;	//总条数
	private List list;	//数据
	
	public PageBean() {
		this.list = new ArrayList();
		this.pageSize = 1;
		// TODO Auto-generated constructor stub
	}
	public PageBean(int p, int pageSize, int pageTotal, int count, List list) {
		this.p = p;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.count = count;
		this.list = list;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
