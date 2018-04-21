package com.perfact.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.g4.perfact.exam.common.action.UserAction;
import com.qhit.lh.g4.perfact.exam.common.bean.Users;

public class UserTest {

	@Test
	public void Login() {
		UserAction userAction = new UserAction();
		
		Users user = new Users();
		user.setName("admin");
		user.setPwd("123456");
		user.setRole(4);
		userAction.setUser(user);
		System.out.println(userAction.login());
		
	}

}
