package com.qhit.lh.g4.cx.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.jay.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jay.exam.kmgl.dao.CourseDao;
import com.qhit.lh.g4.jay.exam.kmgl.dao.CourseDaoImpl;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();

	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return courseDao.getCoursesList(parameter);
	}


}
