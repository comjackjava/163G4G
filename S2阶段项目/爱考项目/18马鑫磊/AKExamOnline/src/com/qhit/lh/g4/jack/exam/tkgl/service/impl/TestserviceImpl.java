package com.qhit.lh.g4.jack.exam.tkgl.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.util.Base64;

import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;
import com.qhit.lh.g4.jack.exam.tkgl.dao.Testdao;
import com.qhit.lh.g4.jack.exam.tkgl.dao.impl.TestdaoImpl;
import com.qhit.lh.g4.jack.exam.tkgl.service.Testservice;

public class TestserviceImpl implements Testservice{
private Testdao testdao =new TestdaoImpl();
	@Override
	public List<Course> getCourseInfo(Map parameter) {
		// TODO Auto-generated method stub
		return testdao.getCourseInfo(parameter);
	}
	@Override
	public PageBean<WrittenTest> getWrittenList(PageBean<WrittenTest> pageBean,
			Course course, int pageIndex) {
		// TODO Auto-generated method stub
		return testdao.getWrittenList(pageBean, course, pageIndex);
	}
	
	@Override
	public PageBean<WrittenTest> getTestList(PageBean<WrittenTest> pageBean,
			Course course, int pageIndex) {
		// TODO Auto-generated method stub
		return testdao.getTestList(pageBean, course, pageIndex);
	}
	@Override
	public void addWrittenTest(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		testdao.addWrittenTest(writtenTest);
	}
	@Override
	public WrittenTest getWrittenQuestionById(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		return testdao.getWrittenQuestionById(writtenTest);
	}
	@Override
	public void updateWrittenTest(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		 testdao.updateWrittenTest(writtenTest);
	}
	@Override
	public void inportWrittenTest(List<WrittenTest> listTests) {
		// TODO Auto-generated method stub
		testdao.inportWrittenTest(listTests);
	}

	@Override
	public int getTestMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		return testdao.getTestMax(csId, qtype, degree);
	}
	@Override
	public Set<WrittenTest> getTestByType(int csId, String qtype, String degree,int num) {
		// TODO Auto-generated method stub
		return testdao.getTestByType(csId, qtype, degree, num);
	}

}
