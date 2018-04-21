package com.qhit.lh.g4.perfact.exam.subject_management.service.impl;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;
import com.qhit.lh.g4.perfact.exam.subject_management.dao.CourseDao;
import com.qhit.lh.g4.perfact.exam.subject_management.dao.impl.CourseDaoImpl;
import com.qhit.lh.g4.perfact.exam.subject_management.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();
	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return courseDao.getCoursesList(parameter);
	}

}
