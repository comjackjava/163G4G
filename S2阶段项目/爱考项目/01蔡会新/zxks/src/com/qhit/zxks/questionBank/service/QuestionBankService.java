package com.qhit.zxks.questionBank.service;

import java.util.ArrayList;
import java.util.List;

import com.qhit.zxks.common.bean.Major;
import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.bean.Stage;
import com.qhit.zxks.common.dao.CommonDao;
import com.qhit.zxks.questionBank.bean.CourseQuestionVO;
import com.qhit.zxks.questionBank.bean.Question;
import com.qhit.zxks.questionBank.dao.QuestionBankDao;

public class QuestionBankService {
	private QuestionBankDao questionBankDao = new QuestionBankDao();
	private CommonDao commonDao = new CommonDao();
	public List<Major> selMajor(){
		return commonDao.selMajor();
	}
	public List<Stage> selStage(){
		return commonDao.selStage();
	}
	public List<CourseQuestionVO> selCourseQuestionVO(int mid, int sid){
		return questionBankDao.getCourseQuestionVO(mid, sid);
	}
	/**
	 * 分页查询试题
	 * @param cid
	 * @param qtype
	 * @param p
	 * @return
	 */
	public PageBean selQuestionPage(int cid,int qtype,int p){
		List<Integer> qtypes = new ArrayList<Integer>();
		if(qtype==0){
			qtypes.add(1);
			qtypes.add(2);
		}else if(qtype==3){
			qtypes.add(3);
		}
		return questionBankDao.getQuestionPage(cid, qtypes, p);
	}
	/**
	 * 添加试题
	 * @param question
	 */
	public void addQuestion(Question question){
		questionBankDao.save(question);
	}
	/**
	 * 根据ID查询试题
	 * @param qid
	 * @return
	 */
	public Question selQuestionByQid(int qid){
		return questionBankDao.getQuestionById(qid);
	}
}
