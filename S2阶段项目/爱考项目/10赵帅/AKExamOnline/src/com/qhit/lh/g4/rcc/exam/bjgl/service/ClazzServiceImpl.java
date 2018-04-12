package com.qhit.lh.g4.rcc.exam.bjgl.service;

import java.util.List;

import com.qhit.lh.g4.rcc.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.g4.rcc.exam.bjgl.dao.ClazzDao;
import com.qhit.lh.g4.rcc.exam.bjgl.dao.ClazzDaoImpl;

public class ClazzServiceImpl implements ClazzService {
	private ClazzDao clazzDao = new ClazzDaoImpl();

	@Override
	public List<ClassInfo> getClazzList() {
		return clazzDao.getClazzList();
	}

}
