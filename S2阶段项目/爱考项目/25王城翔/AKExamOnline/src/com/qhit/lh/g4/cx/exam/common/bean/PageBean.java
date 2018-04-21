package com.qhit.lh.g4.cx.exam.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 3509375972998939764L;
	public static String CURRENT_INDEX = "currentIndex";
	public static String PAGE_SIZE = "pageSize";
	public static String INDEX="index";
	/**
	 * 当前�?
	 */
	private int currentIndex;
	
	/**
	 * 每页记录�?
	 */
	private int pageSize;
	
	/**
	 * 总记录数
	 */
	private int totalNumber;
	
	/**
	 * 总页�?
	 */
	private int totalPage;
	
	/**
	 * 下一�?
	 */
	private int nextIndex;
	
	/**
	 * 上一�?
	 */
	private int preIndex;
	
	/**
	 * 当前页的数据记录
	 */
	private List<T> Items;
	
	
	/**
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param totalNumber
	 * @param currentIndex
	 * @param pageSize
	 * @param items
	 */
	public PageBean(int totalNumber,int currentIndex,int pageSize,List<T> items){
		this.totalNumber = totalNumber;
		this.currentIndex = currentIndex;
		this.pageSize = pageSize;
		this.Items = items;
	}
	
	public PageBean() {
		pageSize = 10;
		Items = new ArrayList<>();
	}
	

	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	/**
	 * @param currentIndex
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	/**
	 * @return
	 */
	public int getTotalNumber() {
		return totalNumber;
	}
	
	/**
	 * @param totalNumber
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		int size = this.totalNumber/this.pageSize;
		if(this.totalNumber%this.pageSize != 0){
			size = size + 1;
		}
		this.totalPage = size;
	}
	
	/**
	 * 总页�?
	 * @return
	 */
	public int getTotalPage() {
		return this.totalPage;
	}

	/**
	 * 当前页的下一页，如果当前耶大于等于最后一�?
	 * 那么下一页就是最后一页�?
	 * 
	 * @return
	 */
	public int getNextIndex() {
		
		if(this.currentIndex >= this.getTotalPage()){
			this.nextIndex = this.currentIndex;
		}else{
			this.nextIndex = this.currentIndex + 1;
		}
		return nextIndex;
	}

	/**
	 * 当前页的上一页，如果当前页小于第�?��那么上一页为1
	 * @return
	 */
	public int getPreIndex() {
		
		if(this.currentIndex <= 1){
			this.preIndex = 1;
		}else{
			this.preIndex = this.currentIndex -1;
		}
		
		return preIndex;
	}

	/**
	 * @return
	 */
	public List<T> getItems() {
		return Items;
	}
	
	/**
	 * @param items
	 */
	public void setItems(List<T> items) {
		Items = items;
	}
}
