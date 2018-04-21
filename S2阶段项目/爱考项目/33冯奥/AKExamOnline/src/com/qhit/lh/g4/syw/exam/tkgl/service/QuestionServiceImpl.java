package com.qhit.lh.g4.syw.exam.tkgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.syw.exam.common.bean.PageBean;
import com.qhit.lh.g4.syw.exam.kmgl.bean.Course;
import com.qhit.lh.g4.syw.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.g4.syw.exam.tkgl.dao.QuestionDao;
import com.qhit.lh.g4.syw.exam.tkgl.dao.QuestionDaoImpl;

public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao = new QuestionDaoImpl();

	@Override
	public List<Course> getCourseInfo(Map parameter) {
		return questionDao.getCourseInfo(parameter);
	}

	@Override
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, 
			Course course,
			int pageIndex) {
		return questionDao.getWrittenList(pageBean, course, pageIndex);
	}

	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		questionDao.addWrittenQuestion(writtenQuestion);
	}

	@Override
	public WrittenQuestion getWrittenQuestionById(
			WrittenQuestion writtenQuestion) {
		return questionDao.getWrittenQuestionById(writtenQuestion);
	}

	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		questionDao.updateWrittenQuestion(writtenQuestion);
	}
	
	@Override
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions) {
		questionDao.inportWrittenQuestions(listWQuestions);
	}

	@Override
	public int getQuestionsMax(int csId,String qtype,String degree) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsMax(csId, qtype, degree);
	}

	@Override
	public List<WrittenQuestion> getQuestionsByType(int csId, String qtype,
			String degree) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsByType(csId, qtype, degree);
	}

}
