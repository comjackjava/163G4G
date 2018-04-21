/**
 * 
 */
package com.qhit.lh.g4.syw.exam;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.g4.syw.exam.common.bean.User;
import com.qhit.lh.g4.syw.exam.common.dao.BaseDao;
import com.qhit.lh.g4.syw.exam.jsgl.bean.Teacher;

public class TeacherTest extends BaseDao {
	
	@Test
	public void add(){
		Teacher teacher = new Teacher();
		teacher.setTname("aaa");
		teacher.setSex("女");
		teacher.setPost("辅导员");
		
		User user = new User();
		user.setName("150202");
		user.setPwd("123456");
		user.setRole(2);
		
		teacher.setUser(user);
		
		Transaction ts = getSession().beginTransaction();
		getSession().save(teacher);
		ts.commit();
		
		
	}
}
