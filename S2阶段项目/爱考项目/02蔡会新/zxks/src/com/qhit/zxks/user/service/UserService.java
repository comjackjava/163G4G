package com.qhit.zxks.user.service;

import com.qhit.zxks.common.dao.StudentDAO;
import com.qhit.zxks.common.dao.TeacherDAO;
import com.qhit.zxks.user.dao.AccountDAO;

/**
 * @类名:UserService 
 * @类描述:
 * @作者:王东方
 * @创建时间:2018-1-2 上午8:58:35
 * @版本:
 * 
 */
public class UserService {
	private AccountDAO accountDAO = new AccountDAO();
	private TeacherDAO teacherDAO = new TeacherDAO();
	private StudentDAO studentDAO = new StudentDAO();
	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @param role
	 * @return
	 */
	public Object login(String username,String password,int role){
		if(role == 0){	//管理员
			return accountDAO.selAccountForLogin(username, password);
		}else if(role == 1){	//老师
			return teacherDAO.selAccountForLogin(username, password);
		}else if(role == 2){		//学生
			return studentDAO.selAccountForLogin(username, password);
		}
		return null;
	}

}
