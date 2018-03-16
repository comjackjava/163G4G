package com.qhit.lh.g4.jack.exam.common.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.g4.jack.exam.common.bean.User;
import com.qhit.lh.g4.jack.exam.common.dao.Basedao;
import com.qhit.lh.g4.jack.exam.common.dao.Userdao;

public class UserdaoImpl extends Basedao  implements Userdao{

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql ="select user from User user where user.name=? and user.pwd=? and user.role=? ";
		Query query =getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		List<User> list =query.list();
		if(list!=null && list.size()==1){
			User users=list.get(0);
			return  users;
		}
		return null;
	}


}
