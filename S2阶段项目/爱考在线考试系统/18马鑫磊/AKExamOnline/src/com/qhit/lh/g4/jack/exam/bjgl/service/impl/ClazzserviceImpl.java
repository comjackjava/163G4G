package com.qhit.lh.g4.jack.exam.bjgl.service.impl;

import java.util.List;

import com.qhit.lh.g4.jack.exam.bjgl.bean.Classinfo;
import com.qhit.lh.g4.jack.exam.bjgl.dao.Clazzdao;
import com.qhit.lh.g4.jack.exam.bjgl.dao.impl.ClazzdaoImpl;
import com.qhit.lh.g4.jack.exam.bjgl.service.Clazzservice;

public class ClazzserviceImpl implements Clazzservice {
private Clazzdao clazzdao =new  ClazzdaoImpl();
	@Override
	public List<Classinfo> getClazzList() {
		// TODO Auto-generated method stub
		return clazzdao.getClazzList();
	}

}
