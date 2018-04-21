package com.qhit.zxks.testPaper.action;

import java.util.List;

import com.qhit.zxks.common.bean.Course;
import com.qhit.zxks.common.bean.Major;
import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.bean.Stage;
import com.qhit.zxks.testPaper.bean.Examination;
import com.qhit.zxks.testPaper.service.ExaminationService;
/**
 * 试卷action
 * @author S01
 *
 */
public class ExaminationAction {
	private List<Major> majors;	//专业集合
	private List<Stage> stages;	//阶段集合
	private Examination examination;
	private int p;
	private int mid;
	private int sid;
	private List<Course> courses;	//课程集合
	private PageBean pageBean;
	private ExaminationService examinationService = new ExaminationService();
	/**
	 * 试卷展示
	 * @return
	 */
	public String showExamination(){
		majors = examinationService.selMajor();
		stages = examinationService.selStage();
		pageBean = examinationService.selExaminationPage(p);
		return "examinationList";
	}
	/**
	 * 查询课程
	 * @return
	 */
	public String selCourse(){
		courses = examinationService.selCourse(mid, sid);
		return "json";
	}
	/**
	 * 根据条件查询试卷
	 * @return
	 */
	public String selExaminationOption(){
		majors = examinationService.selMajor();
		stages = examinationService.selStage();
		pageBean = examinationService.selExaminationOption(p, examination);
		return "examinationList";
	}
	public void setP(int p) {
		this.p = p;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public List<Major> getMajors() {
		return majors;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Examination getExamination() {
		return examination;
	}
	public void setExamination(Examination examination) {
		this.examination = examination;
	}
	
}
