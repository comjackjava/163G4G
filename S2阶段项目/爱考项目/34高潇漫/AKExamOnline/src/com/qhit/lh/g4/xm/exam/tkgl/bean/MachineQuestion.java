package com.qhit.lh.g4.xm.exam.tkgl.bean;

import com.qhit.lh.g4.xm.exam.kmgl.bean.Course;

public class MachineQuestion implements java.io.Serializable {


	private Integer qid;
	private String qtitle;
	private String degree;
	private Integer csId;
	private String chapter;
	
	//n-1
	private Course course;


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public MachineQuestion() {
	}

	

	public MachineQuestion(Integer qid, String qtitle, String degree, Integer csId,
			String chapter) {
		super();
		this.qid = qid;
		this.qtitle = qtitle;
		this.degree = degree;
		this.csId = csId;
		this.chapter = chapter;
	}

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}
	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getQtitle() {
		return this.qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

}