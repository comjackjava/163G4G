package com.qhit.lh.g4.perfact.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.g4.perfact.exam.common.utils.HibernateSessionFactory;

public class BaseDao {
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}	
