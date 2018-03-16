package com.qhit.lh.g4.jack.exam.common.service.impl;

import com.qhit.lh.g4.jack.exam.common.bean.User;
import com.qhit.lh.g4.jack.exam.common.dao.Userdao;
import com.qhit.lh.g4.jack.exam.common.dao.impl.UserdaoImpl;
import com.qhit.lh.g4.jack.exam.common.service.Userservice;

public class UserserviceImpl implements Userservice {
	private Userdao userdao = new UserdaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userdao.login(user);
	}




	
}
