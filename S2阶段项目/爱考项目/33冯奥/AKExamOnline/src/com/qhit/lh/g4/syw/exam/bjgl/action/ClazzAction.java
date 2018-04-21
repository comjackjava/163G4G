package com.qhit.lh.g4.syw.exam.bjgl.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.syw.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.g4.syw.exam.bjgl.service.ClazzService;
import com.qhit.lh.g4.syw.exam.bjgl.service.ClazzServiceImpl;

public class ClazzAction extends ActionSupport {
	private ClazzService clazzService = new ClazzServiceImpl();
	private List<ClassInfo> listClazz;
	
	public String getClazzList(){
		listClazz = clazzService.getClazzList();		
		return "getClazzList";
	}
	
	public List<ClassInfo> getListClazz(){
		
		return listClazz;
	}
	
	public void setListClazz(List<ClassInfo> listClazz) {
		this.listClazz = listClazz;
	}
}
