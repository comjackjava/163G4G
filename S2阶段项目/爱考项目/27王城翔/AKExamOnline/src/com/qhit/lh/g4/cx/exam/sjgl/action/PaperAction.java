package com.qhit.lh.g4.cx.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.jay.exam.common.bean.PageBean;
import com.qhit.lh.g4.jay.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jay.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jay.exam.sjgl.bean.PaperClass;
import com.qhit.lh.g4.jay.exam.sjgl.service.PaperService;
import com.qhit.lh.g4.jay.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.g4.jay.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.g4.jay.exam.tkgl.service.QuestionService;
import com.qhit.lh.g4.jay.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.g4.jay.exam.tkgl.utils.RandomQuestionsUtils;

public class PaperAction extends ActionSupport {
	private PaperService paperService = new PaperServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private List<Paper> listPapers = new ArrayList<>();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定�?初始化为1
	//条件参数
	private Course course;
	private Paper paper;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
	//�?��考试，班级集�?
	private List<PaperClass> paperClasses = new ArrayList<>();
	
	/**
	 * @return
	 * 获取试卷列表
	 */
	public String getPaperList(){
		//设置参数
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("csId", course.getCsId());
		}
		if(paper != null){
			parameter.put("pType", paper.getPtype());
			parameter.put("pState", paper.getPstate());
		}
		//查询题库列表数据
		pageBean = paperService.getPaperList(pageBean, parameter, pageIndex);
		System.out.println(pageBean.getItems().size());
		return "listPaper";
	}
	
	/**
	 * @return
	 * 随机组卷
	 */
	public String createByRandom(){
		System.out.println("1，查询所有的类型的试�?);
		//1，查询所有的类型的试�?
		listRE = questionService.getQuestionsByType(course.getCsId(), "单�?", "�?��");
		listRN = questionService.getQuestionsByType(course.getCsId(), "单�?", "�?��");
		listRD = questionService.getQuestionsByType(course.getCsId(), "单�?", "困难");
		listCE = questionService.getQuestionsByType(course.getCsId(), "多�?", "�?��");
		listCN = questionService.getQuestionsByType(course.getCsId(), "多�?", "�?��");
		listCD = questionService.getQuestionsByType(course.getCsId(), "多�?", "困难");
		//2，随机获取试题集�?
		System.out.println("2，随机获取试题集�?);
		Set<WrittenQuestion> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE, listRN, listRD, listCE, listCN, listCD, 
				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);
		System.out.println("试题数量:"+lisQuestions.size());
		//3，设置试题和试卷的关�?
		System.out.println("3，设置试题和试卷的关�?);
		paper.setWrittenQuestions(lisQuestions);
		//4，设置课程，添加关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//5，添加试�?
		System.out.println("4，添加试�?);
		paperService.createPaperRandom(paper);
		
		return "createRandom";
	}
	
	/**
	 * @return
	 * 结束考试
	 */
	public String endExam(){
		paperService.endExam(paper);
		return "endExam";
	}
	
	public String startExam(){
		paperService.startExam(paperClasses, paper);
		return "startExam";
	}

	public List<Course> getListCourses() {
		return listCourses;
	}

	public List<Paper> getListPapers() {
		return listPapers;
	}

	public PageBean<Paper> getPageBean() {
		return pageBean;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

	public void setListPapers(List<Paper> listPapers) {
		this.listPapers = listPapers;
	}

	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public int getRadioEasy() {
		return radioEasy;
	}

	public int getRadioNormal() {
		return radioNormal;
	}

	public int getRadioDiff() {
		return radioDiff;
	}

	public int getCbEasy() {
		return cbEasy;
	}

	public int getCbNormal() {
		return cbNormal;
	}

	public int getCbDiff() {
		return cbDiff;
	}

	public void setRadioEasy(int radioEasy) {
		this.radioEasy = radioEasy;
	}

	public void setRadioNormal(int radioNormal) {
		this.radioNormal = radioNormal;
	}

	public void setRadioDiff(int radioDiff) {
		this.radioDiff = radioDiff;
	}

	public void setCbEasy(int cbEasy) {
		this.cbEasy = cbEasy;
	}

	public void setCbNormal(int cbNormal) {
		this.cbNormal = cbNormal;
	}

	public void setCbDiff(int cbDiff) {
		this.cbDiff = cbDiff;
	}

	public List<WrittenQuestion> getListRE() {
		return listRE;
	}

	public List<WrittenQuestion> getListRN() {
		return listRN;
	}

	public List<WrittenQuestion> getListRD() {
		return listRD;
	}

	public List<WrittenQuestion> getListCE() {
		return listCE;
	}

	public List<WrittenQuestion> getListCN() {
		return listCN;
	}

	public List<WrittenQuestion> getListCD() {
		return listCD;
	}

	public void setListRE(List<WrittenQuestion> listRE) {
		this.listRE = listRE;
	}

	public void setListRN(List<WrittenQuestion> listRN) {
		this.listRN = listRN;
	}

	public void setListRD(List<WrittenQuestion> listRD) {
		this.listRD = listRD;
	}

	public void setListCE(List<WrittenQuestion> listCE) {
		this.listCE = listCE;
	}

	public void setListCN(List<WrittenQuestion> listCN) {
		this.listCN = listCN;
	}

	public void setListCD(List<WrittenQuestion> listCD) {
		this.listCD = listCD;
	}

	public List<PaperClass> getPaperClasses() {
		return paperClasses;
	}

	public void setPaperClasses(List<PaperClass> paperClasses) {
		this.paperClasses = paperClasses;
	}
	
}
