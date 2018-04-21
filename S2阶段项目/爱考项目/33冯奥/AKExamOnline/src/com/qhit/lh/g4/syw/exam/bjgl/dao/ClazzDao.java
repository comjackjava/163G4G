package com.qhit.lh.g4.syw.exam.bjgl.dao;

import java.util.List;

import com.qhit.lh.g4.syw.exam.bjgl.bean.ClassInfo;

public interface ClazzDao {
	/**
	 * @return
	 * 获取班级集合
	 */
	public List<ClassInfo> getClazzList();
}
