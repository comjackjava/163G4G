/**
 * 
 */
package com.qhit.lh.g4.cx.exam.common.dao;

import com.qhit.lh.g4.jay.exam.common.bean.User;

/**
 * @author admin
 * 2017�?2�?7�?
 */
public interface UserDao {
	/**
	 * @param user
	 * @return
	 * 登录
	 */
	public User login(User user);
}
