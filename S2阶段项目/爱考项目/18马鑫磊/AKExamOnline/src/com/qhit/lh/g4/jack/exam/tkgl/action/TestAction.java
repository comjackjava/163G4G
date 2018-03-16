package com.qhit.lh.g4.jack.exam.tkgl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;
import com.qhit.lh.g4.jack.exam.tkgl.service.Testservice;
import com.qhit.lh.g4.jack.exam.tkgl.service.impl.TestserviceImpl;
import com.qhit.lh.g4.jack.exam.tkgl.utils.PoiReaderExcel;

public class TestAction  extends ActionSupport {
private Testservice testservice  =new TestserviceImpl();
private Course course;
private String major;//专业方向
private String stage;//阶段
private WrittenTest writtenTest;
private List<Course> listCourses = new ArrayList<Course>();
private PageBean<WrittenTest> pageBean = new PageBean<WrittenTest>();
private int pageIndex = 1;//指定页,初始化为1
//导入试题集合
private List<WrittenTest> listTests = new ArrayList<WrittenTest>();
	//导入文件对象
private File testfile;
private int radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;
//题库管理


public List<WrittenTest> getListTests() {
	return listTests;
}
public Testservice getTestservice() {
	return testservice;
}
public void setTestservice(Testservice testservice) {
	this.testservice = testservice;
}
public int getRadioEasyMax() {
	return radioEasyMax;
}
public void setRadioEasyMax(int radioEasyMax) {
	this.radioEasyMax = radioEasyMax;
}
public int getRadioNormalMax() {
	return radioNormalMax;
}
public void setRadioNormalMax(int radioNormalMax) {
	this.radioNormalMax = radioNormalMax;
}
public int getRadioDiffMax() {
	return radioDiffMax;
}
public void setRadioDiffMax(int radioDiffMax) {
	this.radioDiffMax = radioDiffMax;
}
public int getCbEasyMax() {
	return cbEasyMax;
}
public void setCbEasyMax(int cbEasyMax) {
	this.cbEasyMax = cbEasyMax;
}
public int getCbNormalMax() {
	return cbNormalMax;
}
public void setCbNormalMax(int cbNormalMax) {
	this.cbNormalMax = cbNormalMax;
}
public int getCbDiffMax() {
	return cbDiffMax;
}
public void setCbDiffMax(int cbDiffMax) {
	this.cbDiffMax = cbDiffMax;
}
public void setListTests(List<WrittenTest> listTests) {
	this.listTests = listTests;
}
public File getTestfile() {
	return testfile;
}
public void setTestfile(File testfile) {
	this.testfile = testfile;
}
public WrittenTest getWrittenTest() {
	return writtenTest;
}
public void setWrittenTest(WrittenTest writtenTest) {
	this.writtenTest = writtenTest;
}
public PageBean<WrittenTest> getPageBean() {
	return pageBean;
}
public void setPageBean(PageBean<WrittenTest> pageBean) {
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
public String getCourseInfo(){

	//设置参数

	Map<String, String> parameter = new HashMap<String, String>();

	if(major != null && !"".equals(major)){

		parameter.put("major", major);

	}

	if(stage != null && !"".equals(stage)){

		parameter.put("stage", stage);

	}

	//查询题库列表数据

	listCourses = testservice.getCourseInfo(parameter);

	System.out.println(listCourses.size());

	return "listCourse";

}

/**

 * @return

 * 批量导入笔试题

 * @throws FileNotFoundException 

 */

public String inportWrittenTest() throws FileNotFoundException{

	

	if(testfile != null){

		//1,上传到服务器（struts2）(1,jsp表单提交控件、2，action)

		FileInputStream fis = new FileInputStream(testfile);

		//2,读取excel文件中的数据,获取试题对象集合（POI:1,导包、2，读取数据流获取数据集合）

		listTests = PoiReaderExcel.readerExcel(fis, course);

		//3,批量添加到数据库(hibernate)

		testservice.inportWrittenTest(listTests);

	}else{

		//上传文件失败的判断，暂时不做

	}

	return "inportWrittenTest";

}
//获取笔试题信息
public String getWrittenList(){
	//接收并保存参数
		
	pageBean = testservice.getWrittenList(pageBean, course, pageIndex);

	System.out.println("数据大小:"+pageBean.getItems().size());
	
	return "listWritten";
}
//获取笔试题信息
public String getTestList(){
	//接收并保存参数
		
	pageBean = testservice.getTestList(pageBean, course, pageIndex);
	System.out.println("数据大小:"+pageBean.getItems().size());
	System.out.println("已经成功查询出当前course列表");
	
	return "listTest";
}
//添加笔试试题
public String addWrittenTest(){
	System.out.println("*****************");
	System.out.println(
			"当前获取的writtenTest对象:"+
	"Qtype:"+writtenTest.getQtype()+
	"Qtitle:"+writtenTest.getQtitle()+
	"OptionA:"+writtenTest.getOptionA()+
	"OptionB:"+writtenTest.getOptionB()+
	"OptionC:"+writtenTest.getOptionC()+	
	"OptionD:"+writtenTest.getOptionD()+
	"Answer:"+writtenTest.getAnswer()+
	"Degree:"+writtenTest.getDegree()+
	"CsId::"+writtenTest.getCsId()+
	"Chapter:"+writtenTest.getChapter()	
			);
	System.out.println("*****************");
	writtenTest.setCsId(course.getCsId());
	writtenTest.setCourse(course);
	//接收并保存参数
	testservice.addWrittenTest(writtenTest);
	ServletActionContext.getRequest().setAttribute("csId", course.getCsId());
	ServletActionContext.getRequest().setAttribute("csName", course.getCsName());
	return "addWrittenTest";
}

public String getWrittenTestById(){
	writtenTest = testservice.getWrittenQuestionById(writtenTest);
	return "getWrittenTestById";
}

public String updateWrittenTest(){
	writtenTest.setCourse(course);
	testservice.updateWrittenTest(writtenTest);
	return "updateWrittenTest";

}
//获取最大题目数
public String getTestMax(){
	
	radioEasyMax = testservice.getTestMax(writtenTest.getCsId(), "单选", "简单");
	radioNormalMax = testservice.getTestMax(writtenTest.getCsId(), "单选", "一般");
	radioDiffMax = testservice.getTestMax(writtenTest.getCsId(), "单选", "困难");
	cbEasyMax = testservice.getTestMax(writtenTest.getCsId(), "多选", "简单");
	cbNormalMax = testservice.getTestMax(writtenTest.getCsId(), "多选", "一般");
	cbDiffMax = testservice.getTestMax(writtenTest.getCsId(), "多选", "困难");
	
	return "getTestMax";
}


	
}
