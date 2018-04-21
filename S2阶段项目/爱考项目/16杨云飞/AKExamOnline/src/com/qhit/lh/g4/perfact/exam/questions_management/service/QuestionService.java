/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.questions_management.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;
import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

/**
 * @author 万曦晖
 *TODO
 *2018年1月3日下午3:38:20
 */
public interface QuestionService {
	
	/**
	 * 题库管理
	 * @param mjId
	 * @param stage
	 * @return
	 * 题库列表
	 */
	public List<Course> getCourseInfo(Map parameter);

	/**
	 * @param pageBean
	 * @return
	 * 笔试题列表分页数据
	 */
	public PageBean<WrittenTest> getWrittenList(
			PageBean<WrittenTest> pageBean, 
			Course course,
			int pageIndex);
	
	/**
	 * @param pageBean
	 * @return
	 * 添加笔试题
	 */
	public void addWrittenQuestion(WrittenTest writtenTest);
	
	/**
	 * @param writtenQuestion
	 * @return
	 * 根据id查询试题
	 */
	public WrittenTest getWrittenQuestionById(WrittenTest writtenTest);
	
	/**
	 * @param writtenQuestion
	 * 更新数据
	 */
	public void updateWrittenQuestion(WrittenTest writtenTest);
	
	/**
	 * @param listWQuestions
	 * 批量导入笔试题
	 */
	public void inportWrittenQuestions(List<WrittenTest> writtenTests);

	/**
	 * @return
	 * 获取题目数
	 */
	public int getQuestionsMax(int csId,String qtype,String degree);
	
	/**
	 * @return
	 * 获取试题集合
	 */
	public List<WrittenTest> getQuestionsByType(int csId,String qtype,String degree);
}
