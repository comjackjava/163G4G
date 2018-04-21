package com.qhit.zxks.testPaper.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.dao.BaseHibernateDAO;
import com.qhit.zxks.testPaper.bean.Examination;

public class ExaminationDao extends BaseHibernateDAO {
	/**
	 * 分页查询所有试卷
	 * @param p
	 * @return
	 */
	public PageBean getExaminationPage(int p){
		PageBean pb = new PageBean();	//创建分页对象
		int pageSize = pb.getPageSize();
		Criteria criteria = getSession().createCriteria(Examination.class);
		long count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setFirstResult((p-1)*pageSize);	//从第几条开始查
		criteria.setMaxResults(pageSize);		//设置查询几条
		List list = criteria.list();		//查询数据
		pb.setP(p);
		int countInt = Integer.parseInt(String.valueOf(count));
		pb.setCount(countInt);
		pb.setPageTotal((int)Math.ceil(countInt*1.0/pageSize));	//设置总页数
		pb.setList(list);
		return pb;
	}
	/**
	 * 根据条件分页查询试卷
	 * @param p
	 * @return
	 */
	public PageBean getExaminationOptionPage(int p,Examination examination){
		PageBean pb = new PageBean();	//创建分页对象
		int pageSize = pb.getPageSize();
		Criteria criteria = getSession().createCriteria(Examination.class);
		if(examination.getCid()!=0){
			criteria.add(Restrictions.eq("cid", examination.getCid()));
		}
		if(examination.getEtype()!=0){
			criteria.add(Restrictions.eq("etype", examination.getEtype()));
		}
		if(examination.getEstate()!=0){
			criteria.add(Restrictions.eq("estate", examination.getEstate()));
		}
		long count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setFirstResult((p-1)*pageSize);	//从第几条开始查
		criteria.setMaxResults(pageSize);		//设置查询几条
		List list = criteria.list();		//查询数据
		pb.setP(p);
		int countInt = Integer.parseInt(String.valueOf(count));
		pb.setCount(countInt);
		pb.setPageTotal((int)Math.ceil(countInt*1.0/pageSize));	//设置总页数
		pb.setList(list);
		return pb;
	}
}
