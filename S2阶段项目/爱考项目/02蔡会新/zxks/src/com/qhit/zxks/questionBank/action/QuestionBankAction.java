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
	private List<Major> majors;	//רҵ����
	private List<Stage> stages;	//�׶μ���
	private List<CourseQuestionVO> courseQuestions;	//��Ŀ����������
	private int mid;	//רҵID
	private int sid;	//�׶�id
	private int p;	//��ǰҳ
	private int cid;	//�γ�id
	private int qtype;	//��Ŀ����
	private String cname;	//��Ŀ��
	private int qid;//����ID
	private PageBean pageBean;	//��ҳ����
	private Question question;
	private QuestionBankService questionBankService = new QuestionBankService();
	/**
	 * ���չʾ
	 * @return
	 */
	public String showQuestionBank(){
		courseQuestions = questionBankService.selCourseQuestionVO(mid, sid);
		return "json";
	}
	/**
	 * ��ʼ��ҳ�棬��ѯרҵ�׶�
	 * @return
	 */
	public String selMajorStage(){
		majors = questionBankService.selMajor();
		stages = questionBankService.selStage();
		return "questionBankList";
	}
	/**
	 * ����չʾ
	 * @return
	 */
	public String showQuestion(){
		System.out.println(cname);
		pageBean = questionBankService.selQuestionPage(cid, qtype, p);
		return "questionList";
	}
	/**
	 * �������
	 * @return
	 */
	public String addQuestion(){
		System.out.println(question);
		questionBankService.addQuestion(question);
		return "json";
	}
	/**
	 * ׼���༭����
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
