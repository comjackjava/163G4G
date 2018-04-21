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
 * �Ծ�ҵ����
 * @author S01
 *
 */
public class ExaminationService {
	private ExaminationDao examinationDao = new ExaminationDao();
	private CommonDao commonDao = new CommonDao();
	/**
	 * ��ҳ��ѯ�����Ծ�
	 * @return
	 */
	public PageBean selExaminationPage(int p){
		return examinationDao.getExaminationPage(p);
	}
	/**
	 * ��ҳ��ѯ�����Ծ�
	 * @return
	 */
	public PageBean selExaminationOption(int p,Examination examination){
		System.out.println(examination);
		return examinationDao.getExaminationOptionPage(p, examination);
	}
	/**
	 * ��ѯרҵ
	 * @return
	 */
	public List<Major> selMajor(){
		return commonDao.selMajor();
	}
	/**
	 * ��ѯ�׶�
	 * @return
	 */
	public List<Stage> selStage(){
		return commonDao.selStage();
	}
	/**
	 * ��ѯ�γ�
	 * @return
	 */
	public List<Course> selCourse(int mid,int sid){
		return commonDao.selCourse(mid, sid);
	}
}
