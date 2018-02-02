package com.qhit.lh.g4.jack.exam.bjgl.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.jack.exam.bjgl.bean.Classinfo;
import com.qhit.lh.g4.jack.exam.bjgl.service.Clazzservice;
import com.qhit.lh.g4.jack.exam.bjgl.service.impl.ClazzserviceImpl;

public class ClazzAction extends ActionSupport {

	private Clazzservice clazzService = new ClazzserviceImpl();

	private List<Classinfo> listClazz;

	

	public String getClazzList(){

		listClazz = clazzService.getClazzList();

		return "getClazzList";

	}



	public List<Classinfo> getListClazz() {

		return listClazz;

	}



	public void setListClazz(List<Classinfo> listClazz) {

		this.listClazz = listClazz;

	}

}