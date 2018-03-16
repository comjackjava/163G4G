package com.qhit.lh.g4.jack.exam.kmgl.service.impl;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.kmgl.dao.Coursedao;
import com.qhit.lh.g4.jack.exam.kmgl.dao.impl.CoursedaoImpl;
import com.qhit.lh.g4.jack.exam.kmgl.service.Courseservice;


public class CourseserviceImpl implements Courseservice{
	private Coursedao coursedao =new CoursedaoImpl();
	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		
		return coursedao.getCoursesList(parameter);
	}



}
