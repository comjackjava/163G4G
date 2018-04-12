/**
 * 
 */
package com.qhit.lh.g4.cx.exam;

import org.junit.Test;

import com.qhit.lh.g4.jay.exam.common.action.UserAction;
import com.qhit.lh.g4.jay.exam.common.bean.User;

/**
 * @author admin
 * 2017å¹?2æœ?7æ—?
 */
public class UserTest {

	@Test
	public void login(){
		UserAction userAction = new UserAction();
		
		User user = new User();
		user.setName("admin");
		user.setPwd("123456");
		user.setRole(4);
		
		userAction.setUser(user);
		
		System.out.println(userAction.login());;
		
	}
}
