package com.qhit.lh.g4.jack.exam.kmgl.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.qhit.lh.g4.jack.exam.common.utils.HibernateSessionFactory;

public class Basedao {
public Session getSession (){
	return HibernateSessionFactory.getSession();
}
}
