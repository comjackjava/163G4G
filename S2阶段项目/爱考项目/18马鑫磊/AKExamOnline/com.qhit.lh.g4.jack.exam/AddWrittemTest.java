import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.g4.jack.exam.common.dao.Basedao;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;
import com.qhit.lh.g4.jack.exam.tkgl.dao.Testdao;
import com.qhit.lh.g4.jack.exam.tkgl.dao.impl.TestdaoImpl;



public class AddWrittemTest extends Basedao{
	@Test
	public void addWrittenTest(){
		Transaction ts = getSession().beginTransaction();
		
		WrittenTest writtenTest =new WrittenTest("单选", "public", "1", "2", "3", "4", "A", "简单", 1, "T1");
	
		Course course =(Course) getSession().get(Course.class, 1);
		
		writtenTest.setCourse(course);
		
		getSession().save(writtenTest);
		
		ts.commit();
	}
	@Test
	public void addWrittenTestOld(){
		
		
		WrittenTest writtenTest =new WrittenTest("单选", "public", "1", "2", "3", "4", "A", "简单", 1, "T1");
	
		Course course =(Course) getSession().get(Course.class, 1);
		
		writtenTest.setCourse(course);
		
		Testdao testdao =new TestdaoImpl();
		testdao.addWrittenTest(writtenTest);
		
	}
	
	
}
