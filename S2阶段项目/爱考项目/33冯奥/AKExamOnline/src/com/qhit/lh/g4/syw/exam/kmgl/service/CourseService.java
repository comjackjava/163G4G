package com.qhit.lh.g4.syw.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.syw.exam.kmgl.bean.Course;

public interface CourseService {

	/**
	 * @param course
	 * @return
	 */
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
