package com.qhit.zxks.testPaper.action;

import java.util.List;

import com.qhit.zxks.common.bean.Course;
import com.qhit.zxks.common.bean.Major;
import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.bean.Stage;
import com.qhit.zxks.testPaper.bean.Examination;
import com.qhit.zxks.testPaper.service.ExaminationService;
/**
 * �Ծ�action
 * @author S01
 *
 */
public class ExaminationAction {
	private List<Major> majors;	//רҵ����
	private List<Stage> stages;	//�׶μ���
	private Examination examination;
	private int p;
	private int mid;
	private int sid;
	private List<Course> courses;	//�γ̼���
	private PageBean pageBean;
	private ExaminationService examinationService = new ExaminationService();
	/**
	 * �Ծ�չʾ
	 * @return
	 */
	public String showExamination(){
		majors = examinationService.selMajor();
		stages = examinationService.selStage();
		pageBean = examinationService.selExaminationPage(p);
		return "examinationList";
	}
	/**
	 * ��ѯ�γ�
	 * @return
	 */
	public String selCourse(){
		courses = examinationService.selCourse(mid, sid);
		return "json";
	}
	/**
	 * ����������ѯ�Ծ�
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
