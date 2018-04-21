	package com.qhit.lh.g4.perfact.exam.examinationpaper_management.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.bean.Paper;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.bean.PaperClass;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.service.PaperService;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.service.PaperServiceImpl;
import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;
import com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService;
import com.qhit.lh.g4.perfact.exam.questions_management.service.impl.QuestionServiceImpl;
import com.qhit.lh.g4.perfact.exam.questions_management.util.RandomQuestionsUtils;
import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

public class PaperAction extends ActionSupport {
	private PaperService paperService = new PaperServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private List<Paper> listPapers = new ArrayList<>();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页,初始化为1
	//条件参数
	private Course course;
	private Paper paper;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	private List<WrittenTest> listRE,listRN,listRD,listCE,listCN,listCD;
	//开始考试
	private Set<PaperClass> paperClasses;
	
	
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
		System.out.println("1，查询所有的类型的试题");
		//1，查询所有的类型的试题
		listRE = questionService.getQuestionsByType(course.getCsId(), "单选", "简单");
		listRN = questionService.getQuestionsByType(course.getCsId(), "单选", "一般");
		listRD = questionService.getQuestionsByType(course.getCsId(), "单选", "困难");
		listCE = questionService.getQuestionsByType(course.getCsId(), "多选", "简单");
		listCN = questionService.getQuestionsByType(course.getCsId(), "多选", "一般");
		listCD = questionService.getQuestionsByType(course.getCsId(), "多选", "困难");
		//2，随机获取试题集合
		System.out.println("2，随机获取试题集合");
		Set<WrittenTest> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE, listRN, listRD, listCE, listCN, listCD, 
				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);
		System.out.println("试题数量:"+lisQuestions.size());
		//3，设置试题和试卷的关系
		System.out.println("3，设置试题和试卷的关系");
		paper.setWrittenQuestions(lisQuestions);
		//4，设置课程，添加关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//5，添加试卷
		System.out.println("4，添加试卷");
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

	public int getRadioEasy() {
		return radioEasy;
	}

	public void setRadioEasy(int radioEasy) {
		this.radioEasy = radioEasy;
	}

	public int getRadioNormal() {
		return radioNormal;
	}

	public void setRadioNormal(int radioNormal) {
		this.radioNormal = radioNormal;
	}

	public int getRadioDiff() {
		return radioDiff;
	}

	public void setRadioDiff(int radioDiff) {
		this.radioDiff = radioDiff;
	}

	public int getCbEasy() {
		return cbEasy;
	}

	public void setCbEasy(int cbEasy) {
		this.cbEasy = cbEasy;
	}

	public int getCbNormal() {
		return cbNormal;
	}

	public void setCbNormal(int cbNormal) {
		this.cbNormal = cbNormal;
	}

	public int getCbDiff() {
		return cbDiff;
	}

	public void setCbDiff(int cbDiff) {
		this.cbDiff = cbDiff;
	}

	public List<WrittenTest> getListRE() {
		return listRE;
	}

	public void setListRE(List<WrittenTest> listRE) {
		this.listRE = listRE;
	}

	public List<WrittenTest> getListRN() {
		return listRN;
	}

	public void setListRN(List<WrittenTest> listRN) {
		this.listRN = listRN;
	}

	public List<WrittenTest> getListRD() {
		return listRD;
	}

	public void setListRD(List<WrittenTest> listRD) {
		this.listRD = listRD;
	}

	public List<WrittenTest> getListCE() {
		return listCE;
	}

	public void setListCE(List<WrittenTest> listCE) {
		this.listCE = listCE;
	}

	public List<WrittenTest> getListCN() {
		return listCN;
	}

	public void setListCN(List<WrittenTest> listCN) {
		this.listCN = listCN;
	}

	public List<WrittenTest> getListCD() {
		return listCD;
	}

	public void setListCD(List<WrittenTest> listCD) {
		this.listCD = listCD;
	}

	public Set<PaperClass> getPaperClasses() {
		return paperClasses;
	}

	public void setPaperClasses(Set<PaperClass> paperClasses) {
		this.paperClasses = paperClasses;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	
}
