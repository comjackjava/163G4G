/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.questions_management.service.impl;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;
import com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao;
import com.qhit.lh.g4.perfact.exam.questions_management.dao.impl.QuestionDaoImpl;
import com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService;
import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

/**
 * @author 万曦晖
 *TODO
 *2018年1月3日下午3:39:13
 */
public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao = new QuestionDaoImpl();
	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#getCourseInfo(java.util.Map)
	 */
	@Override
	public List<Course> getCourseInfo(Map parameter) {
		// TODO Auto-generated method stub
		return questionDao.getCourseInfo(parameter);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#getWrittenList(com.qhit.lh.g4.perfact.exam.common.bean.PageBean, com.qhit.lh.g4.perfact.exam.subject_management.bean.Course, int)
	 */
	@Override
	public PageBean<WrittenTest> getWrittenList(PageBean<WrittenTest> pageBean, Course course, int pageIndex) {
		// TODO Auto-generated method stub
		return questionDao.getWrittenList(pageBean, course, pageIndex);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#addWrittenQuestion(com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest)
	 */
	@Override
	public void addWrittenQuestion(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		questionDao.addWrittenQuestion(writtenTest);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#getWrittenQuestionById(com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest)
	 */
	@Override
	public WrittenTest getWrittenQuestionById(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		return questionDao.getWrittenQuestionById(writtenTest);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#updateWrittenQuestion(com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest)
	 */
	@Override
	public void updateWrittenQuestion(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		questionDao.updateWrittenQuestion(writtenTest);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#inportWrittenQuestions(java.util.List)
	 */
	@Override
	public void inportWrittenQuestions(List<WrittenTest> writtenTests) {
		// TODO Auto-generated method stub
		questionDao.inportWrittenQuestions(writtenTests);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#getQuestionsMax(int, java.lang.String, java.lang.String)
	 */
	@Override
	public int getQuestionsMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsMax(csId, qtype, degree);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService#getQuestionsByType(int, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WrittenTest> getQuestionsByType(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsByType(csId, qtype, degree);
	}

}
