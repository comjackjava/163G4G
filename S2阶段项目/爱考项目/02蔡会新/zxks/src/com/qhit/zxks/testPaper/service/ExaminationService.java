package com.qhit.zxks.testPaper.service;

import java.awt.print.Pageable;
import java.util.List;

import com.qhit.zxks.common.bean.Course;
import com.qhit.zxks.common.bean.Major;
import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.bean.Stage;
import com.qhit.zxks.common.dao.CommonDao;
import com.qhit.zxks.testPaper.bean.Examination;
import com.qhit.zxks.testPaper.dao.ExaminationDao;
/**
 * 试卷业务类
 * @author S01
 *
 */
public class ExaminationService {
	private ExaminationDao examinationDao = new ExaminationDao();
	private CommonDao commonDao = new CommonDao();
	/**
	 * 分页查询所有试卷
	 * @return
	 */
	public PageBean selExaminationPage(int p){
		return examinationDao.getExaminationPage(p);
	}
	/**
	 * 分页查询所有试卷
	 * @return
	 */
	public PageBean selExaminationOption(int p,Examination examination){
		System.out.println(examination);
		return examinationDao.getExaminationOptionPage(p, examination);
	}
	/**
	 * 查询专业
	 * @return
	 */
	public List<Major> selMajor(){
		return commonDao.selMajor();
	}
	/**
	 * 查询阶段
	 * @return
	 */
	public List<Stage> selStage(){
		return commonDao.selStage();
	}
	/**
	 * 查询课程
	 * @return
	 */
	public List<Course> selCourse(int mid,int sid){
		return commonDao.selCourse(mid, sid);
	}
}
