package com.qhit.lh.g4.syw.exam.bjgl.dao;

import java.util.List;

import com.qhit.lh.g4.syw.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.g4.syw.exam.common.dao.BaseDao;

public class ClazzDaoImpl extends BaseDao implements ClazzDao {

	@Override
	public List<ClassInfo> getClazzList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from ClassInfo").list();
	}

}
