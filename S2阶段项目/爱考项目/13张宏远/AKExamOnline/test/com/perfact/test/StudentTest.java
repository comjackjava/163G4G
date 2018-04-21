package com.perfact.test;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.g4.perfact.exam.common.bean.Users;
import com.qhit.lh.g4.perfact.exam.common.dao.BaseDao;
import com.qhit.lh.g4.perfact.exam.student_management.bean.Student;

public class StudentTest extends BaseDao{

	@Test
	public void add() {
		//新建学生
		Student student = new Student();
		student.setSname("Music");
		student.setSex("男");
		student.setEnterSchool("2016");
		student.setcCode("");
		//分配账户
		Users user = new Users();
		user.setName("16030221031");
		user.setPwd("123456");
		user.setRole(1);
		
		student.setUser(user);
		Transaction ts = getSession().beginTransaction();
		getSession().save(student);
		ts.commit();
	}

}
