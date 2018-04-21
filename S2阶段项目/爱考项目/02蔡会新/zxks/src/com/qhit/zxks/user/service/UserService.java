package com.qhit.zxks.user.service;

import com.qhit.zxks.common.dao.StudentDAO;
import com.qhit.zxks.common.dao.TeacherDAO;
import com.qhit.zxks.user.dao.AccountDAO;

/**
 * @����:UserService 
 * @������:
 * @����:������
 * @����ʱ��:2018-1-2 ����8:58:35
 * @�汾:
 * 
 */
public class UserService {
	private AccountDAO accountDAO = new AccountDAO();
	private TeacherDAO teacherDAO = new TeacherDAO();
	private StudentDAO studentDAO = new StudentDAO();
	/**
	 * ��½
	 * @param username
	 * @param password
	 * @param role
	 * @return
	 */
	public Object login(String username,String password,int role){
		if(role == 0){	//����Ա
			return accountDAO.selAccountForLogin(username, password);
		}else if(role == 1){	//��ʦ
			return teacherDAO.selAccountForLogin(username, password);
		}else if(role == 2){		//ѧ��
			return studentDAO.selAccountForLogin(username, password);
		}
		return null;
	}

}
