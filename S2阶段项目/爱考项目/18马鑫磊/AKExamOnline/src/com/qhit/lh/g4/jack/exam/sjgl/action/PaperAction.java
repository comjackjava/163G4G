package com.qhit.lh.g4.jack.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

		private Set<WrittenTest>  listRE,listRN,listRD,listCE,listCN,listCD;

		//开始考试，班级集合

		private List<PaperClass> paperClasses =new ArrayList<PaperClass>();
		//选题组卷
		
		private String [] question;
	/**

	 * @return

	 * 获取试卷列表

	 */

	
	public int getRadioEasy() {
		return radioEasy;
	}
	
	public String[] getQuestion() {
		return question;
	}

	public void setQuestion(String[] question) {
		this.question = question;
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

	public Paperservice getPaperservice() {
		return paperservice;
	}

	public void setPaperservice(Paperservice paperservice) {
		this.paperservice = paperservice;
	}

	public Testservice getTestservice() {
		return testservice;
	}

	public void setTestservice(Testservice testservice) {
		this.testservice = testservice;
	}

	

	public Set<WrittenTest> getListRE() {
		return listRE;
	}

	public void setListRE(Set<WrittenTest> listRE) {
		this.listRE = listRE;
	}

	public Set<WrittenTest> getListRN() {
		return listRN;
	}

	public void setListRN(Set<WrittenTest> listRN) {
		this.listRN = listRN;
	}

	public Set<WrittenTest> getListRD() {
		return listRD;
	}

	public void setListRD(Set<WrittenTest> listRD) {
		this.listRD = listRD;
	}

	public Set<WrittenTest> getListCE() {
		return listCE;
	}

	public void setListCE(Set<WrittenTest> listCE) {
		this.listCE = listCE;
	}

	public Set<WrittenTest> getListCN() {
		return listCN;
	}

	public void setListCN(Set<WrittenTest> listCN) {
		this.listCN = listCN;
	}

	public Set<WrittenTest> getListCD() {
		return listCD;
	}

	public void setListCD(Set<WrittenTest> listCD) {
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
	
	public String getPointsTestList(){
		Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("pid",paper.getPid());
			System.out.println(paper.getPid());
		//查询题库列表数据
				paper = paperservice.getPointsTestList(parameter);

		return "pointsTestList";
	}
	public String getPaperPointsList(){

		//设置参数

		Map<String, Object> parameter = new HashMap<String, Object>();

		if(course != null){

			parameter.put("csId", course.getCsId());

		}

		if(paper != null){

			parameter.put("pType", paper.getPtype());


		}
		parameter.put("pState", "考试结束");
		//查询题库列表数据

		pageBean = paperservice.getPaperList(pageBean, parameter, pageIndex);

		System.out.println(pageBean.getItems().size());

		return "listPaperPoints";

	}
	public String createByChoose() {
		//设置试卷课程的关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//从session中获取已选试题集合
		Set<WrittenTest> questions = new HashSet<WrittenTest>();
		for (String qid : question) {
			WrittenTest writtenQuestion = new WrittenTest();
			writtenQuestion.setQid(Integer.valueOf(qid));
			questions.add(writtenQuestion);
		}
		//设置试卷和试题集合的关系
		
		paper.setWrittenTests(questions);
		//创建试卷
		paperservice.createByChoose(paper);
		
		return "createByChoose";
	}
	
	//创建随机组卷试卷
	public String createByRandom(){
		System.out.println("1，查询所有的类型的试题");

		//1，查询所有的类型的试题

		listRE = testservice.getTestByType(course.getCsId(), "单选", "简单",radioEasy);

		listRN = testservice.getTestByType(course.getCsId(), "单选", "一般",radioNormal);

		listRD = testservice.getTestByType(course.getCsId(), "单选", "困难",radioDiff);

		listCE = testservice.getTestByType(course.getCsId(), "多选", "简单",cbEasy);

		listCN = testservice.getTestByType(course.getCsId(), "多选", "一般",cbNormal);

		listCD = testservice.getTestByType(course.getCsId(), "多选", "困难",cbDiff);

		//2，随机获取试题集合

		System.out.println("2，随机获取试题集合");
		Set<WrittenTest> lisQuestions = new HashSet<WrittenTest>();
		for (WrittenTest writtenTest : listRE) {
			lisQuestions.add(writtenTest);
		}
		for (WrittenTest writtenTest : listRN) {
			lisQuestions.add(writtenTest);
		}
		for (WrittenTest writtenTest : listRD) {
			lisQuestions.add(writtenTest);
		}
		for (WrittenTest writtenTest : listCE) {
			lisQuestions.add(writtenTest);
		}
		for (WrittenTest writtenTest : listCN) {
			lisQuestions.add(writtenTest);
		}
		for (WrittenTest writtenTest : listCD) {
			lisQuestions.add(writtenTest);
		}
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
