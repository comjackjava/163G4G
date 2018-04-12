package com.qhit.lh.g4.xm.exam.common.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.xm.exam.common.utils.HibernateSessionFactory;
public class BaseDao {

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
