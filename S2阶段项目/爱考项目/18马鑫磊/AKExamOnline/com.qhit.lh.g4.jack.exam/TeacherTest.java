import java.util.Iterator;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Test;

import com.qhit.lh.g4.jack.exam.common.bean.Teacher;
import com.qhit.lh.g4.jack.exam.common.bean.User;
import com.qhit.lh.g4.jack.exam.common.utils.HibernateSessionFactory;
import com.qhit.lh.g4.jack.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;


public class TeacherTest {
@Test
public void  add(){
	Paper paper = (Paper)HibernateSessionFactory.getSession().get(Paper.class,28);
	WrittenTest writtenTest;
	for (WrittenTest test : paper.getWrittenTests()) {
		System.out.println(test.getQtitle());
	}

}


}
