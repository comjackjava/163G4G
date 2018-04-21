package com.qhit.lh.g4.perfact.exam.common.service.impl;

import com.qhit.lh.g4.perfact.exam.common.bean.Users;
import com.qhit.lh.g4.perfact.exam.common.dao.UserDao;
import com.qhit.lh.g4.perfact.exam.common.dao.impl.UserDaoImpl;
import com.qhit.lh.g4.perfact.exam.common.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public Users Login(Users user) {
		// TODO Auto-generated method stub
		return userDao.Login(user);
	}

}
