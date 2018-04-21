/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.questions_management.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.common.dao.BaseDao;
import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;
import com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao;
import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

/**
 * @author 万曦晖
 *TODO
 *2018年1月2日上午11:36:21
 */
public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#getCourseInfo(java.util.Map)
	 */
	@Override
	public List<Course> getCourseInfo(Map parameter) {
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1");
		//拼接HQL
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//执行查询
		return query.list();
	}

	@Override
	public PageBean<WrittenTest> getWrittenList(
			PageBean<WrittenTest> pageBean, 
			Course course,
			int pageIndex) {
		// TODO Auto-generated method stub
		//hql语句
		StringBuffer hql = new StringBuffer();
		hql.append("select w from WrittenTest w where w.csId = :csId");
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置分页查询参数
		query.setInteger("csId", course.getCsId());
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<WrittenTest> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();

		pageBean.setItems(items);

		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#addWrittenQuestion(com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest)
	 */
	@Override
	public void addWrittenQuestion(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行添加，返回新纪录的主键
		long id = (long) getSession().save(writtenTest);
		//提交事务
		ts.commit();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#getWrittenQuestionById(com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest)
	 */
	@Override
	public WrittenTest getWrittenQuestionById(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		return (WrittenTest) getSession().get(WrittenTest.class, writtenTest.getQid());
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#updateWrittenQuestion(com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest)
	 */
	@Override
	public void updateWrittenQuestion(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		getSession().clear();
		Transaction ts = getSession().beginTransaction();
		getSession().update(writtenTest);
		ts.commit();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#inportWrittenQuestions(java.util.List)
	 */
	@Override
	public void inportWrittenQuestions(List<WrittenTest> writtenTests) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		for(WrittenTest writtenTest : writtenTests) {
			getSession().save(writtenTest);
		}
		ts.commit();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#getQuestionsMax(int, java.lang.String, java.lang.String)
	 */
	@Override
	public int getQuestionsMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(WrittenTest.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", qtype))
				.add(Restrictions.eq("degree", degree));
		
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.count("qid"));
		
		criteria.setProjection(projectionList);
		long num = (long) criteria.list().get(0);
		return (int)num;
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.questions_management.dao.QuestionDao#getQuestionsByType(int, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WrittenTest> getQuestionsByType(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(WrittenTest.class)
					.add(Restrictions.eq("csId", csId))
					.add(Restrictions.eq("qtype", qtype))
					.add(Restrictions.eq("degree", degree));
		return criteria.list();
	}

}
