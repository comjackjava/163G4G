/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.questions_management.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;
import com.qhit.lh.g4.perfact.exam.questions_management.service.QuestionService;
import com.qhit.lh.g4.perfact.exam.questions_management.service.impl.QuestionServiceImpl;
import com.qhit.lh.g4.perfact.exam.questions_management.util.PoiReaderExce;
import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

/**
 * @author 万曦晖
 *TODO
 *2018年1月2日上午11:26:56
 */
public class QuestionAction extends ActionSupport {
	private QuestionService questionService = new QuestionServiceImpl();
	private Course course;//课程
	private String major;//专业方向
	private String stage;//阶段
	private WrittenTest writtenTests;//笔试题对象
	private List<Course> listCourses = new ArrayList<>();
	//试题列表分页数据
	private PageBean<WrittenTest> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页,初始化为1
	//导入试题集合
	private List<WrittenTest> listWQuestions = new ArrayList<>();
	//导入文件对象
	private File questionfile;
	
	private int radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;
	/**
	 * @return
	 * 题库列表
	 */
	public String getCourseInfo(){
		//设置参数
		Map<String, String> parameter = new HashMap<>();
		if(major != null && !"".equals(major)){
			parameter.put("major", major);
		}
		if(stage != null && !"".equals(stage)){
			parameter.put("stage", stage);
		}
		//查询题库列表数据
		listCourses = questionService.getCourseInfo(parameter);
		return "listCourse";
	}
	
	public String getQuestionMax(){
		radioEasyMax = questionService.getQuestionsMax(writtenTests.getCsId(), "单选", "简单");
		radioNormalMax = questionService.getQuestionsMax(writtenTests.getCsId(), "单选", "一般");
		radioDiffMax = questionService.getQuestionsMax(writtenTests.getCsId(), "单选", "困难");
		cbEasyMax = questionService.getQuestionsMax(writtenTests.getCsId(), "多选", "简单");
		cbNormalMax = questionService.getQuestionsMax(writtenTests.getCsId(), "多选", "一般");
		cbDiffMax = questionService.getQuestionsMax(writtenTests.getCsId(), "多选", "困难");
		
		return "getQuestionMax";
	}
	
	/**
	 * @return
	 * 获取试题列表
	 */
	public String getWrittenList(){
		pageBean = questionService.getWrittenList(pageBean, course, pageIndex);
		System.out.println("数据大小:"+pageBean.getItems().size());
		return "listWritten";
	}
	
	/**
	 * @return
	 * 添加笔试题
	 */
	public String addWrittenTest(){
		System.out.println(writtenTests.getCsId());
		//设置课程试题的关联
		writtenTests.setCourse(course);
		
		questionService.addWrittenQuestion(writtenTests);
		return "addWrittenQuestion";
	}
	
	/**
	 * @return
	 * 根据试题编号查询试题对象
	 */
	public String getWrittenTestById(){
		writtenTests = questionService.getWrittenQuestionById(writtenTests);
		return "getWrittenQuestionById";
	}
	
	/**
	 * @return
	 * 更新
	 */
	public String updateWrittenTest(){
		//设置关联
		writtenTests.setCourse(course);
		
		questionService.updateWrittenQuestion(writtenTests);
		return "updateWrittenQuestion";
	}
	
	/**
	 * @return
	 * 批量导入笔试题
	 * @throws FileNotFoundException 
	 */
	public String inportWrittenTests() throws FileNotFoundException{
		
		if(questionfile != null){
			//1,上传到服务器（struts2）(1,jsp表单提交控件、2，action)
			FileInputStream fis = new FileInputStream(questionfile);
			//2,读取excel文件中的数据,获取试题对象集合（POI:1,导包、2，读取数据流获取数据集合）
			listWQuestions = PoiReaderExce.readerExcel(fis, course);
			//3,批量添加到数据库(hibernate)
			questionService.inportWrittenQuestions(listWQuestions);
		}else{
			//上传文件失败的判断，暂时不做
		}
		return "inportWrittenQuestions";
	}
	
	public PageBean<WrittenTest> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<WrittenTest> pageBean) {
		this.pageBean = pageBean;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}



	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<Course> getListCourses() {
		return listCourses;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public WrittenTest getWrittenTest() {
		return writtenTests;
	}

	public void setWrittenTest(WrittenTest WrittenTest) {
		this.writtenTests = WrittenTest;
	}

	public List<WrittenTest> getListWQuestions() {
		return listWQuestions;
	}

	public void setListWQuestions(List<WrittenTest> listWQuestions) {
		this.listWQuestions = listWQuestions;
	}

	public File getQuestionfile() {
		return questionfile;
	}

	public void setQuestionfile(File questionfile) {
		this.questionfile = questionfile;
	}

	public int getRadioEasyMax() {
		return radioEasyMax;
	}

	public int getRadioNormalMax() {
		return radioNormalMax;
	}

	public int getRadioDiffMax() {
		return radioDiffMax;
	}

	public int getCbEasyMax() {
		return cbEasyMax;
	}

	public int getCbNormalMax() {
		return cbNormalMax;
	}

	public int getCbDiffMax() {
		return cbDiffMax;
	}

	public void setRadioEasyMax(int radioEasyMax) {
		this.radioEasyMax = radioEasyMax;
	}

	public void setRadioNormalMax(int radioNormalMax) {
		this.radioNormalMax = radioNormalMax;
	}

	public void setRadioDiffMax(int radioDiffMax) {
		this.radioDiffMax = radioDiffMax;
	}

	public void setCbEasyMax(int cbEasyMax) {
		this.cbEasyMax = cbEasyMax;
	}

	public void setCbNormalMax(int cbNormalMax) {
		this.cbNormalMax = cbNormalMax;
	}

	public void setCbDiffMax(int cbDiffMax) {
		this.cbDiffMax = cbDiffMax;
	}
}
