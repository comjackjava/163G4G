package com.qhit.lh.g4.perfact.exam.subject_management.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

public interface CourseService {
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
