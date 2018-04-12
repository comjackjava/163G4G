/**
 * 
 */
package com.qhit.lh.g4.cx.exam;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.g4.jay.exam.common.bean.User;
import com.qhit.lh.g4.jay.exam.common.dao.BaseDao;
import com.qhit.lh.g4.jay.exam.jsgl.bean.Teacher;

/**
 * @author admin
 * 2017�?2�?7�?
 */
public class TeacherTest extends BaseDao {
	
	@Test
	public void add(){
		Teacher teacher = new Teacher();
		teacher.setTname("张亚�?);
		teacher.setSex("�?);
		teacher.setPost("辅导�?);
		
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
