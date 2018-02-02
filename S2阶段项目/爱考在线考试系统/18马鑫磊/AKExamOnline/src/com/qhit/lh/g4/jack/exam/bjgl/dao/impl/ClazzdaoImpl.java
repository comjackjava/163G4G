package com.qhit.lh.g4.jack.exam.bjgl.dao.impl;

import java.util.List;

import com.qhit.lh.g4.jack.exam.bjgl.bean.Classinfo;
import com.qhit.lh.g4.jack.exam.bjgl.dao.Clazzdao;
import com.qhit.lh.g4.jack.exam.common.dao.Basedao;

public class ClazzdaoImpl extends Basedao implements Clazzdao {

	@Override
	public List<Classinfo> getClazzList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Classinfo").list();
	}

}
