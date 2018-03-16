import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.junit.Test;

import com.qhit.lh.g4.jack.exam.common.utils.HibernateSessionFactory;
import com.qhit.lh.g4.jack.exam.kmgl.dao.Coursedao;
import com.qhit.lh.g4.jack.exam.kmgl.dao.impl.CoursedaoImpl;


public class CourseTest {
	@Test
public void query(){
	StringBuffer hql = new StringBuffer("select course.csId,course.csName from Course course where 1 = 1   and course.major = 'SCME' and course.stage = 'G1' ");
	Query query = HibernateSessionFactory.getSession().createQuery(hql.toString());
	System.out.println("查询结束");

}
}
