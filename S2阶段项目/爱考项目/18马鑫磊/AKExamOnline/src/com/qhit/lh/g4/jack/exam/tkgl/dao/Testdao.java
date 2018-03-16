package com.qhit.lh.g4.jack.exam.tkgl.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;

public interface Testdao {
	public List<Course> getCourseInfo(Map parameter);
	public PageBean<WrittenTest> getWrittenList(

			PageBean<WrittenTest> pageBean, 

			Course course,

			int pageIndex);
	
	public PageBean<WrittenTest> getTestList(

			PageBean<WrittenTest> pageBean, 

			Course course,

			int pageIndex);
	public void addWrittenTest(WrittenTest writtenTest);
	
	public WrittenTest getWrittenQuestionById(WrittenTest writtenTest);

	public void updateWrittenTest(WrittenTest writtenTest);

	public void inportWrittenTest(List<WrittenTest> listTests);

	public Set<WrittenTest> getTestByType(int csId,String qtype,String degree,int num);
	
	public int getTestMax(int csId,String qtype,String degree);
}
