package com.qhit.lh.g4.xm.exam.kmgl.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.g4.xm.exam.tkgl.bean.MachineQuestion;
import com.qhit.lh.g4.xm.exam.tkgl.bean.WrittenQuestion;

public class Course implements java.io.Serializable {

	private Integer csId;
	private String csName;
	private String stage;
	private String major;
	
	//1-n
	private Set<WrittenQuestion> writtenQuestions = new HashSet<>();
	private Set<MachineQuestion> machineQuestions = new HashSet<>();
	
	public Course() {
	}

	public Set<WrittenQuestion> getWrittenQuestions() {
		return writtenQuestions;
	}

	public void setWrittenQuestions(Set<WrittenQuestion> writtenQuestions) {
		this.writtenQuestions = writtenQuestions;
	}

	public Set<MachineQuestion> getMachineQuestions() {
		return machineQuestions;
	}

	public void setMachineQuestions(Set<MachineQuestion> machineQuestions) {
		this.machineQuestions = machineQuestions;
	}

	public Course(String csName, String stage) {
		this.csName = csName;
		this.stage = stage;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Course(Integer csId, String csName, String stage, String major) {
		super();
		this.csId = csId;
		this.csName = csName;
		this.stage = stage;
		this.major = major;
	}


	public Integer getCsId() {
		return this.csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return this.csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

}