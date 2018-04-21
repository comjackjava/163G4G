package com.qhit.lh.g4.perfact.exam.common.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.g4.perfact.exam.common.bean.Users;
import com.qhit.lh.g4.perfact.exam.common.dao.BaseDao;
import com.qhit.lh.g4.perfact.exam.common.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
	public Users Login(Users user){
		String hql = "select u from Users u where u.name =? and u.pwd = ? and u.role = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<Users> list = query.list();
		if(list != null && list.size() == 1){
			System.out.println(list);
			return list.get(0);
		}
		
		return null;
	}
}
