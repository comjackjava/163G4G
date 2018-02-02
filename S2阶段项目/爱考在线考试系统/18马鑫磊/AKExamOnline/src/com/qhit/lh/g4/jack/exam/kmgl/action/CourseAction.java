package com.qhit.lh.g4.jack.exam.kmgl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.kmgl.service.Courseservice;
import com.qhit.lh.g4.jack.exam.kmgl.service.impl.CourseserviceImpl;

public class CourseAction {
 private Courseservice courseservice =new CourseserviceImpl();
 private Course course;
 private List<Course> listCourses;
 
 public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

public List<Course> getListCourses() {
	return listCourses;
}

public void setListCourses(List<Course> listCourses) {
	this.listCourses = listCourses;
}

public  String getCourseJson(){

		Map<String, Object> parameter = new HashMap<String, Object>();

		if(course != null){

			parameter.put("major", course.getMajor());

			parameter.put("stage", course.getStage());

		}

		//查询题库列表数据

		listCourses = courseservice.getCoursesList(parameter);

		System.out.println("异步请求:"+listCourses.size());
		System.out.println("已经返回listCourses");

		return "listCourseJson";

 }
}
