/**
 * 
 */
package com.qhit.lh.g4.cx.exam.common.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.jay.exam.common.utils.HibernateSessionFactory;

/**
 * @author admin
 * 2017�?2�?7�?
 */
public class BaseDao {

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
