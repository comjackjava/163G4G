package com.qhit.zxks.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @����:PageBean 
 * @������:
 * @����:������
 * @����ʱ��:2018-1-10 ����8:17:27
 * @�汾:
 * 
 */
public class PageBean {
	private int p;	//��ǰҳ
	private int pageSize; //ÿҳ��ʾ����
	private int pageTotal;	//��ҳ��
	private int count;	//������
	private List list;	//����
	
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
