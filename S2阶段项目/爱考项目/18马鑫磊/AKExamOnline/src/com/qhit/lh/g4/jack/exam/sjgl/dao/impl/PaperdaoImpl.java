package com.qhit.lh.g4.jack.exam.sjgl.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.catalina.ssi.SSIConditional;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.HqlASTFactory;

import com.qhit.lh.g4.jack.exam.bjgl.bean.Classinfo;
import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.common.dao.Basedao;
import com.qhit.lh.g4.jack.exam.common.utils.HibernateSessionFactory;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jack.exam.sjgl.bean.PaperClass;
import com.qhit.lh.g4.jack.exam.sjgl.dao.Paperdao;

public class PaperdaoImpl extends Basedao implements Paperdao {

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,
			Map<String, Object> parameter, int pageIndex) {
		// TODO Auto-generated method stub
		StringBuffer hql =new StringBuffer();
		hql.append("select paper from Paper paper where 1 = 1 ");
		//拼接hql
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){

			hql.append(" and paper.csId = :csId" );

		}

		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){

			hql.append(" and paper.ptype = :pType ");

		}

		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){

			hql.append(" and paper.pstate = :pState ");

		}
		Query query =HibernateSessionFactory.getSession().createQuery(hql.toString());
		//设置参数

			if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){

					query.setInteger("csId", (Integer)parameter.get("csId"));

				}

				if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){

					query.setString("pType", (String) parameter.get("pType"));

				}

				if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){

					query.setString("pState", (String) parameter.get("pState"));

				}
				//总记录数

				int count = query.list().size();

				pageBean.setTotalNumber(count);

				pageBean.setCurrentIndex(pageIndex);

				//当前页数据

				List<Paper> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())

						.setMaxResults(pageBean.getPageSize())

						.list();

				//设置pagebean的数据集合

				pageBean.setItems(items);
				
				//执行查询
					
				return pageBean;
	}

	@Override
	public void endExam(Paper paper) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();

//		paper = (Paper) getSession().get(Paper.class, paper.getPid());

//		paper.setPstate("考试结束");

//		getSession().update(paper);

		String hql = "update Paper paper set paper.pstate = '考试结束' where paper.pid = ?";

		Query queryUpdate = getSession().createQuery(hql);

		queryUpdate.setInteger(0, paper.getPid());

		//执行HQL的添加、修改、删除调用的是executeUpdate方法

		queryUpdate.executeUpdate();

		ts.commit();
		getSession().close();
	}
	@Override
	public void updateExam(Paper paper, String state) {
		Transaction ts = getSession().beginTransaction();
//		paper = (Paper) getSession().get(Paper.class, paper.getPid());
//		paper.setPstate("考试结束");
//		getSession().update(paper);
		String hql = "update Paper paper set paper.pstate = ? where paper.pid = ?";
		Query queryUpdate = getSession().createQuery(hql);
		queryUpdate.setString(0, state);
		queryUpdate.setInteger(1, paper.getPid());
		//执行HQL的添加、修改、删除调用的是executeUpdate方法
		queryUpdate.executeUpdate();
		ts.commit();
		getSession().close();
	}
	@Override
	public void createPaperRandom(Paper paper) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
		getSession().close();
	}

	@Override
	public void startExam(List<PaperClass> paperClasses) {
		Transaction ts = getSession().beginTransaction();
		System.out.println("数据大小:"+paperClasses.size());
		for (PaperClass paperClass : paperClasses) {
			//设置n-1关系
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			Classinfo classinfo = (Classinfo) getSession().get(Classinfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassinfo(classinfo);
			//保存数据
			getSession().save(paperClass);
		}
		ts.commit();
		getSession().close();
	}

	@Override
	public void createByChoose(Paper paper) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
		getSession().close();
	}

	@Override
	public Paper getPointsTestList(Map<String, Object> parameter) {
		
		// TODO Auto-generated method stub
		Paper paper = (Paper) getSession().get(Paper.class,(Integer)parameter.get("pid"));
		
		return paper;
	}





	


}
