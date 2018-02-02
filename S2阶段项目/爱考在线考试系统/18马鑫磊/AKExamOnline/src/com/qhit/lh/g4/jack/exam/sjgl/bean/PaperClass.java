package com.qhit.lh.g4.jack.exam.sjgl.bean;

import java.util.Date;

import com.qhit.lh.g4.jack.exam.bjgl.bean.Classinfo;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;

/**
 * PaperClass entity. @author MyEclipse Persistence Tools
 */

public class PaperClass implements java.io.Serializable {

	// Fields

	private Integer pcId;
	private Integer pid;
	private String ccode;
	private Date examDate;
	private Date endDate;
	//多对一
	private Paper paper;
	private Classinfo classinfo;
	// Constructors

	/** default constructor */
	public PaperClass() {
	}

	public Classinfo getClassinfo() {
		return classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}



	/** full constructor */
	public PaperClass(Integer pid, String ccode, Date examDate, Date endDate) {
		this.pid = pid;
		this.ccode = ccode;
		this.examDate = examDate;
		this.endDate = endDate;
	}

	// Property accessors

	public Integer getPcId() {
		return this.pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getCcode() {
		return this.ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}