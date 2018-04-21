package com.qhit.lh.g4.syw.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.syw.exam.common.bean.PageBean;
import com.qhit.lh.g4.syw.exam.common.utils.RandomUtil;
import com.qhit.lh.g4.syw.exam.kmgl.bean.Course;
import com.qhit.lh.g4.syw.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.syw.exam.sjgl.bean.PaperClass;
import com.qhit.lh.g4.syw.exam.sjgl.service.PaperService;
import com.qhit.lh.g4.syw.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.g4.syw.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.g4.syw.exam.tkgl.service.QuestionService;
import com.qhit.lh.g4.syw.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.g4.syw.exam.tkgl.utils.RandomQuestionsUtils;

public class PaperAction extends ActionSupport {
	private PaperService paperService = new PaperServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private List<Paper> listPapers = new ArrayList<>();
	private QuestionService questionService = new QuestionServiceImpl();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页,初始化为1
	//条件参数
	private Course course;
	private Paper paper;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
	private Set<PaperClass> paperClasses;
	
	/**
	 * @return
	 * 获取试卷列表
	 0*/
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
		System.out.println("1,查询所有类型的试题");
		//查询所有类型的试题
		listRE = questionService.getQuestionsByType(course.getCsId(), "单选", "简单");
		listRN = questionService.getQuestionsByType(course.getCsId(), "单选", "一般");
		listRD = questionService.getQuestionsByType(course.getCsId(), "单选", "困难");
		listCE = questionService.getQuestionsByType(course.getCsId(), "多选", "简单");
		listCN = questionService.getQuestionsByType(course.getCsId(), "多选", "一般");
		listCD = questionService.getQuestionsByType(course.getCsId(), "多选", "困难");
		
		//随机获取试题集合
		System.out.println("2,随机获取试题集合");
		Set<WrittenQuestion> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE,
				listRN,
				listRD, 
				listCE, 
				listCN, 
				listCD,
				radioEasy,
				radioNormal, 
				radioDiff,
				cbEasy, 
				cbNormal,
				cbDiff);
		System.out.println("试题数量："+lisQuestions.size());
		//设置试题和试卷的关系
		System.out.println("3,,设置试题和试卷的关系");
		paper.setWrittenQuestions(lisQuestions);
		//设置课程添加关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//添加试卷
		System.out.println("4,添加试卷");
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

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
}
