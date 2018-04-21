package com.qhit.zxks.testPaper.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.zxks.common.bean.Classes;
import com.qhit.zxks.common.bean.Course;

/**
 * ÊÔ¾íÊµÌåÀà
 * @author S01
 *
 */
public class Examination {
	private int eid;	//ÊÔ¾íID
	private String ename;	//ÊÔ¾íÃû×Ö
	private int cid;	//¿ÆÄ¿id
	private int etype;	//ÊÔ¾íÀàĞÍ£¨1±ÊÊÔ¡¢2»úÊÔ£©
	private int etime;  //¿¼ÊÔÊ±¼ä
	private int estate;	//ÊÔ¾í×´Ì¬(1-Î´¿ª¿¼£¬2-¿¼ÊÔÖĞ£¬3-¿¼ÊÔ½áÊø)
	private Course course;	//¿Î³Ì
	private Set<Classes> classes = new HashSet<Classes>();	//¿¼ÊÔ°à¼¶
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
