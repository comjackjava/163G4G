package com.qhit.lh.g4.jack.exam.common.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qhit.lh.g4.jack.exam.common.utils.HibernateSessionFactory;

public class Basedao {
public Session getSession(){
return HibernateSessionFactory.getSession();
}
}
