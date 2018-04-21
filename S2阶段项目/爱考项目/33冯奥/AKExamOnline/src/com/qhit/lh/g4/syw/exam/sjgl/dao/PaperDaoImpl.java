package com.qhit.lh.g4.syw.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.qhit.lh.g4.syw.exam.common.bean.PageBean;
import com.qhit.lh.g4.syw.exam.common.dao.BaseDao;
import com.qhit.lh.g4.syw.exam.sjgl.bean.Paper;

public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		StringBuffer hql = new StringBuffer();
		hql.append("select paper from Paper paper where 1 = 1");
		//拼接HQL
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.ptype = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pstate = :pState");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
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
		String hql = "update Paper paper set paper.pstate = '考试结束' where paper.pid = ? ";
		Query queryUpdate = getSession().createQuery(hql);
		queryUpdate.setInteger(0, paper.getPid());
		//执行HQL的添加，修改
		queryUpdate.executeUpdate();
		ts.commit();
	}

	@Override
	public void createPaperRandom(Paper paper) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
	}

}
