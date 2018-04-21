package com.perfact.test;

import static org.junit.Assert.*;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.g4.perfact.exam.common.bean.Users;
import com.qhit.lh.g4.perfact.exam.common.dao.BaseDao;
import com.qhit.lh.g4.perfact.exam.teacher_management.bean.Teacher;

public class TeacherTest extends BaseDao{

	@Test
	public void add() {
		Teacher teacher = new Teacher();
		teacher.setTname("Alsanda");
		teacher.setSex("男");
		teacher.setPost("辅导员");
		
		
		Users user = new Users();
		user.setName("150201");
		user.setRole(2);
		
		teacher.setUser(user);
		
		Transaction ts = getSession().beginTransaction();
		getSession().save(teacher);
		ts.commit();
	}

}
