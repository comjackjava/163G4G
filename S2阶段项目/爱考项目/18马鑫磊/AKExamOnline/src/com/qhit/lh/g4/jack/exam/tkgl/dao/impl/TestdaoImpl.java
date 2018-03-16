package com.qhit.lh.g4.jack.exam.tkgl.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.common.dao.Basedao;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;
import com.qhit.lh.g4.jack.exam.tkgl.dao.Testdao;

public class TestdaoImpl extends Basedao implements Testdao {


	@Override
	public List<Course> getCourseInfo(Map parameter) {
		// TODO Auto-generated method stub
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
	public PageBean<WrittenTest> getWrittenList(PageBean<WrittenTest> pageBean,
			Course course, int pageIndex) {
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

	@Override
	public void addWrittenTest(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		//开启事务

				Transaction ts = getSession().beginTransaction();

				//执行添加，返回新纪录的主键
				getSession().flush();
				long id = (Integer) getSession().save(writtenTest);
				System.out.println(id);
				//提交事务

				ts.commit();
				getSession().close();
	}

	@Override
	public WrittenTest getWrittenQuestionById(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		
		return (WrittenTest) getSession().get(WrittenTest.class, writtenTest.getQid());
	}

	@Override
	public void updateWrittenTest(WrittenTest writtenTest) {
		// TODO Auto-generated method stub
		getSession().clear();
		Transaction ts = getSession().beginTransaction();
		getSession().update(writtenTest);
		ts.commit();
		getSession().close();
	}

	@Override
	public void inportWrittenTest(List<WrittenTest> listTests) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();

		for (WrittenTest writtenTest : listTests) {

			//执行添加，返回新纪录的主键

			getSession().save(writtenTest);

		}

		//提交事务

		ts.commit();
		getSession().close();
		
	}

	@Override
	public Set<WrittenTest> getTestByType(int csId, String qtype,
			String degree,int num) {
		// TODO Auto-generated method stub

		StringBuffer hql = new StringBuffer();

		hql.append(" select  w  from  WrittenTest  w  where  w.csId = :csId  and  w.qtype  = :qtype and w.degree = :degree   order by newId() ");
		
		//获取查询器

		Query query = getSession().createQuery(hql.toString());

		//设置分页查询参数

		query.setInteger("csId",csId);
		query.setString("qtype", qtype);
		query.setString("degree", degree);
		query.setMaxResults(num);
	     WrittenTest writtenTest;
		 Set<WrittenTest> lisQuestions = new HashSet<WrittenTest>();
		 for (int i = 0; i < query.list().size(); i++) {
			writtenTest=(WrittenTest) query.list().get(i);
			lisQuestions.add(writtenTest);
		}
		 getSession().close();
		return lisQuestions;
	}

	@Override
	public int getTestMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		Criteria criteria =getSession().createCriteria(WrittenTest.class)
				   .add(Restrictions.eq("csId", csId))
				   .add(Restrictions.eq("qtype", qtype))
				   .add(Restrictions.eq("degree", degree));
		ProjectionList projectionList =Projections.projectionList()
									  .add(Projections.count("qid"));
		criteria.setProjection(projectionList);
		long num =(Long) criteria.list().get(0);
		
		return (int)num;
	}

	@Override
	public PageBean<WrittenTest> getTestList(PageBean<WrittenTest> pageBean,
			Course course, int pageIndex) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//hql语句

						StringBuffer hql = new StringBuffer();

						hql.append("select new WrittenTest(w.qid, w.qtype, w.qtitle, w.degree,w.chapter) from WrittenTest w where w.csId = :csId");

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

}
