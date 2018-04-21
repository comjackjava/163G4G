package com.qhit.zxks.common.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.qhit.zxks.common.bean.Course;
import com.qhit.zxks.common.bean.Major;
import com.qhit.zxks.common.bean.Stage;

/**
 * ����DAO
 * @author S01
 *
 */
public class CommonDao extends BaseHibernateDAO {
	/**
	 * ��ѯרҵ
	 * @return
	 */
	public List<Major> selMajor(){
		String hql = "from Major";
		Query query = getSession().createQuery(hql);
		List<Major> list = query.list();
		return list;
	}
	/**
	 * ��ѯ�׶�
	 * @return
	 */
	public List<Stage> selStage(){
		String hql = "from Stage";
		Query query = getSession().createQuery(hql);
		List<Stage> list = query.list();
		return list;
	}
	/**
	 * ����רҵ�ͽ׶β�ѯ�γ�
	 * @param mid
	 * @param sid
	 * @return
	 */
	public List<Course> selCourse(int mid,int sid){
		Criteria c = getSession().createCriteria(Course.class);
		if(mid != 0){
			c.add(Restrictions.eq("mid", mid));
		}
		if(sid != 0){
			c.add(Restrictions.eq("sid", sid));
		}
		List<Course> courses = c.list();
		return courses;
	}
}
