package com.qhit.lh.g4.jack.t2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.jack.t2.dao.Basedao;
import com.qhit.lh.g4.jack.t2.utils.HibernateSessionFactory;

public class BasedaoImpl implements Basedao {
private Session session =HibernateSessionFactory.getSession();
private Transaction tx=session.beginTransaction();
private List<Object> list=new ArrayList<Object>();
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		session.save(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		session.delete(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		session.update(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public List<Object> queryAll(String sql) {
		// TODO Auto-generated method stub
		list=session.createQuery(sql).list();
		tx.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
