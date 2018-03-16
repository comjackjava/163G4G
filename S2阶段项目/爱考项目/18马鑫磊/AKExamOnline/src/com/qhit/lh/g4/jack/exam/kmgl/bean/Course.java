package com.qhit.lh.g4.jack.exam.kmgl.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.g4.jack.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jack.exam.tkgl.bean.MachineTest;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer csId;
	private String csName;
	private String stage;
	private String major;
	
	//一对多
	private Set<Paper> papers =new HashSet<Paper>();
	private Set<MachineTest> machineTests = new HashSet<MachineTest>();
	private Set<WrittenTest> writtenTests =new HashSet<WrittenTest>();

	// Constructors

	/** default constructor */
	public Course() {
	}



	public Course(Integer csId, String csName) {
		super();
		this.csId = csId;
		this.csName = csName;
	}



	public Set<Paper> getPapers() {
		return papers;
	}



	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}



	public Set<WrittenTest> getWrittenTests() {
		return writtenTests;
	}

	public void setWrittenTests(Set<WrittenTest> writtenTests) {
		this.writtenTests = writtenTests;
	}

	public Set<MachineTest> getMachineTests() {
		return machineTests;
	}

	public void setMachineTests(Set<MachineTest> machineTests) {
		this.machineTests = machineTests;
	}


	/** full constructor */
	public Course(String csName, String stage, String major) {
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

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}