package com.qhit.zxks.questionBank.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.zxks.common.bean.Major;
import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.bean.Stage;
import com.qhit.zxks.questionBank.bean.CourseQuestionVO;
import com.qhit.zxks.questionBank.bean.Question;
import com.qhit.zxks.questionBank.service.QuestionBankService;

public class QuestionBankAction extends ActionSupport {
	private List<Major> majors;	//专业集合
	private List<Stage> stages;	//阶段集合
	private List<CourseQuestionVO> courseQuestions;	//科目试题数集合
	private int mid;	//专业ID
	private int sid;	//阶段id
	private int p;	//当前页
	private int cid;	//课程id
	private int qtype;	//题目类型
	private String cname;	//科目名
	private int qid;//试题ID
	private PageBean pageBean;	//分页对象
	private Question question;
	private QuestionBankService questionBankService = new QuestionBankService();
	/**
	 * 题库展示
	 * @return
	 */
	public String showQuestionBank(){
		courseQuestions = questionBankService.selCourseQuestionVO(mid, sid);
		return "json";
	}
	/**
	 * 初始化页面，查询专业阶段
	 * @return
	 */
	public String selMajorStage(){
		majors = questionBankService.selMajor();
		stages = questionBankService.selStage();
		return "questionBankList";
	}
	/**
	 * 试题展示
	 * @return
	 */
	public String showQuestion(){
		System.out.println(cname);
		pageBean = questionBankService.selQuestionPage(cid, qtype, p);
		return "questionList";
	}
	/**
	 * 添加试题
	 * @return
	 */
	public String addQuestion(){
		System.out.println(question);
		questionBankService.addQuestion(question);
		return "json";
	}
	/**
	 * 准备编辑试题
	 * @return
	 */
	public String preEditQuestion(){
		question = questionBankService.selQuestionByQid(qid);
		return "json";
	}
	public List<Major> getMajors() {
		return majors;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public List<CourseQuestionVO> getCourseQuestions() {
		return courseQuestions;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setP(int p) {
		this.p = p;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setQtype(int qtype) {
		this.qtype = qtype;
	}
	public int getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	
}
