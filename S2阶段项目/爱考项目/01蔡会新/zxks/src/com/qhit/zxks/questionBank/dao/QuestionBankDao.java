package com.qhit.zxks.questionBank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.zxks.common.bean.PageBean;
import com.qhit.zxks.common.dao.BaseHibernateDAO;
import com.qhit.zxks.questionBank.bean.CourseQuestionVO;
import com.qhit.zxks.questionBank.bean.Question;

public class QuestionBankDao extends BaseHibernateDAO {
	public List<CourseQuestionVO> getCourseQuestionVO(int mid ,int sid){
		String hql = "select new com.qhit.zxks.questionBank.bean.CourseQuestionVO(c.cid,c.cname," +
				"sum(case when q.qtype=1 then 1 when q.qtype=2 then 1 else 0 end),"
				+ "sum(case when q.qtype=3 then 1 else 0 end)) "
				+ "from Course c left join  c.questions q   where c.mid=:mid and c.sid = :sid "
				+ "group by c.cid,c.cname";
		Query query = getSession().createQuery(hql);
		query.setInteger("mid", mid);
		query.setInteger("sid", sid);
		List<CourseQuestionVO> list = query.list();
		return list;
	}
	/**
	 * ���ݿ�Ŀ�����ͷ�ҳ��ѯ����
	 * @param cid
	 * @param qtype
	 * @return
	 */
	public PageBean getQuestionPage(int cid,List qtypes,int p){
		PageBean pb = new PageBean();
		int pageSize = pb.getPageSize();
		Criteria criteria = getSession().createCriteria(Question.class);
		criteria.add(Restrictions.eq("cid", cid))
			.add(Restrictions.in("qtype", qtypes));
		long count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setFirstResult((p-1)*pageSize);	//�ӵڼ�����ʼ��
		criteria.setMaxResults(pageSize);		//���ò�ѯ����
		List list = criteria.list();		//��ѯ����
		pb.setP(p);
		int countInt = Integer.parseInt(String.valueOf(count));
		pb.setCount(countInt);
		pb.setPageTotal(countInt/pageSize+1);	//������ҳ��
		pb.setList(list);
		return pb;
	}
	/**
	 * �������
	 * @param transientInstance
	 */
	public void save(Question transientInstance) {
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/**
	 * ����ID��ѯ����
	 * @param qid
	 */
	public 	Question getQuestionById(int qid){
		Question question = (Question) getSession().get(Question.class, qid);
		return question;
	}
}
