package com.qhit.lh.g4.jack.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;

public interface Coursedao {
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
