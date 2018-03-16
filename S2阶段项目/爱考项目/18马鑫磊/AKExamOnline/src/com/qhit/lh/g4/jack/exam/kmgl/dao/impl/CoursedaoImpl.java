package com.qhit.lh.g4.jack.exam.kmgl.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.qhit.lh.g4.jack.exam.common.dao.Basedao;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.kmgl.dao.Coursedao;



public class CoursedaoImpl extends Basedao implements Coursedao {

	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub

		StringBuffer hql = new StringBuffer("select new Course(course.csId,course.csName) from Course course where 1 = 1 ");

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



}
