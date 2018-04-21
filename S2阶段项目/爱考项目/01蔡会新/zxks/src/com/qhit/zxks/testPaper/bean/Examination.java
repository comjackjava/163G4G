package com.qhit.zxks.testPaper.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.zxks.common.bean.Classes;
import com.qhit.zxks.common.bean.Course;

/**
 * �Ծ�ʵ����
 * @author S01
 *
 */
public class Examination {
	private int eid;	//�Ծ�ID
	private String ename;	//�Ծ�����
	private int cid;	//��Ŀid
	private int etype;	//�Ծ����ͣ�1���ԡ�2���ԣ�
	private int etime;  //����ʱ��
	private int estate;	//�Ծ�״̬(1-δ������2-�����У�3-���Խ���)
	private Course course;	//�γ�
	private Set<Classes> classes = new HashSet<Classes>();	//���԰༶
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getEtype() {
		return etype;
	}
	public void setEtype(int etype) {
		this.etype = etype;
	}
	public int getEtime() {
		return etime;
	}
	public void setEtime(int etime) {
		this.etime = etime;
	}
	public int getEstate() {
		return estate;
	}
	public void setEstate(int estate) {
		this.estate = estate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Set<Classes> getClasses() {
		return classes;
	}
	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}
	
}
