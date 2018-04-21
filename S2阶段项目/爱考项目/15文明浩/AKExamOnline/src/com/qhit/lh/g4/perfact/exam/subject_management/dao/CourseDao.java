package com.qhit.lh.g4.perfact.exam.subject_management.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

public interface CourseDao {
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
