package com.qhit.lh.g4.jack.exam.tkgl.bean;

import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;

/**
 * MachineTest entity. @author MyEclipse Persistence Tools
 */

public class MachineTest implements java.io.Serializable {

	// Fields

	private Integer qid;
	private String qtitle;
	private String degree;
	private Integer csId;
	private String chapter;
	//多对一
	private Course course;
	// Constructors

	/** default constructor */
	public MachineTest() {
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/** minimal constructor */
	public MachineTest(String qtitle, String degree, Integer csId) {
		this.qtitle = qtitle;
		this.degree = degree;
		this.csId = csId;
	}

	/** full constructor */
	public MachineTest(String qtitle, String degree, Integer csId,
			String chapter) {
		this.qtitle = qtitle;
		this.degree = degree;
		this.csId = csId;
		this.chapter = chapter;
	}

	// Property accessors

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

	public Integer getCsId() {
		return this.csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

}