/**
 * 
 */
package com.qhit.lh.g4.rcc.exam.common.dao;

import com.qhit.lh.g4.rcc.exam.common.bean.User;

/**
 * @author admin
 * 2017年12月27日
 */
public interface UserDao {
	/**
	 * @param user
	 * @return
	 * 登录
	 */
	public User login(User user);
}
