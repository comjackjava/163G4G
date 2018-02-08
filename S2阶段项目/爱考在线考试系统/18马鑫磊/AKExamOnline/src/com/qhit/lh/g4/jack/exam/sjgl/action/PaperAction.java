package com.qhit.lh.g4.jack.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jack.exam.sjgl.bean.PaperClass;
import com.qhit.lh.g4.jack.exam.sjgl.service.Paperservice;
import com.qhit.lh.g4.jack.exam.sjgl.service.impl.PaperserviceImpl;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;
import com.qhit.lh.g4.jack.exam.tkgl.service.Testservice;
import com.qhit.lh.g4.jack.exam.tkgl.service.impl.TestserviceImpl;
import com.qhit.lh.g4.jack.exam.tkgl.utils.RandomTestUtils;

public class PaperAction extends ActionSupport {
	private Paperservice paperservice =new PaperserviceImpl();
	private Testservice testservice  =new TestserviceImpl();
			
	private List<Course> listCourses = new ArrayList<Course>();
	private List<Paper> listPapers = new ArrayList<Paper>();

	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<Paper>();
	private int pageIndex = 1;//指定页,初始化为1
	//条件参数
	
		private Course course;

		private Paper paper;

		private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;

		private List<WrittenTest> listRE,listRN,listRD,listCE,listCN,listCD;

		//开始考试，班级集合

		private List<PaperClass> paperClasses =new ArrayList<PaperClass>();
	/**

	 * @return

	 * 获取试卷列表

	 */

	
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

	public List<PaperClass> getPaperClasses() {
		return paperClasses;
	}
	public void setPaperClasses(List<PaperClass> paperClasses) {
		this.paperClasses = paperClasses;
	}
	public List<Course> getListCourses() {
		return listCourses;
	}



	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}



	public List<Paper> getListPapers() {
		return listPapers;
	}



	public void setListPapers(List<Paper> listPapers) {
		this.listPapers = listPapers;
	}



	public PageBean<Paper> getPageBean() {
		return pageBean;
	}



	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}



	public int getPageIndex() {
		return pageIndex;
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
	public String getPaperList(){

		//设置参数

		Map<String, Object> parameter = new HashMap<String, Object>();

		if(course != null){

			parameter.put("csId", course.getCsId());

		}

		if(paper != null){

			parameter.put("pType", paper.getPtype());

			parameter.put("pState", paper.getPstate());

		}

		//查询题库列表数据

		pageBean = paperservice.getPaperList(pageBean, parameter, pageIndex);

		System.out.println(pageBean.getItems().size());

		return "listPaper";

	}
	
	//创建随机组卷试卷
	public String createByRandom(){
		System.out.println("1，查询所有的类型的试题");

		//1，查询所有的类型的试题

		listRE = testservice.getTestByType(course.getCsId(), "单选", "简单");

		listRN = testservice.getTestByType(course.getCsId(), "单选", "一般");

		listRD = testservice.getTestByType(course.getCsId(), "单选", "困难");

		listCE = testservice.getTestByType(course.getCsId(), "多选", "简单");

		listCN = testservice.getTestByType(course.getCsId(), "多选", "一般");

		listCD = testservice.getTestByType(course.getCsId(), "多选", "困难");

		//2，随机获取试题集合

		System.out.println("2，随机获取试题集合");

		Set<WrittenTest> lisQuestions = RandomTestUtils.randomAllQuestions(

				listRE, listRN, listRD, listCE, listCN, listCD, 

				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);

		System.out.println("试题数量:"+lisQuestions.size());

		//3，设置试题和试卷的关系

		System.out.println("3，设置试题和试卷的关系");

		paper.setWrittenTests(lisQuestions);

		//4，设置课程，添加关系

		paper.setCsId(course.getCsId());

		paper.setCourse(course);

		//5，添加试卷

		System.out.println("4，添加试卷");

		paperservice.createPaperRandom(paper);

		

		return "createRandom";
	}
	public String startExam(){
		
		paperservice.startExam(paperClasses, paper);
		return "startExam";
	}
	public String endExam(){

		paperservice.endExam(paper);

		return "endExam";

	}
	
}
