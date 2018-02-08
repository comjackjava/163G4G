package com.qhit.lh.g4.jack.exam.sjgl.service.impl;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jack.exam.sjgl.bean.PaperClass;
import com.qhit.lh.g4.jack.exam.sjgl.dao.Paperdao;
import com.qhit.lh.g4.jack.exam.sjgl.dao.impl.PaperdaoImpl;
import com.qhit.lh.g4.jack.exam.sjgl.service.Paperservice;

public class PaperserviceImpl  implements Paperservice{
	private Paperdao paperdao =new PaperdaoImpl();
	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,
			Map<String, Object> parameter, int pageIndex) {
		// TODO Auto-generated method stub
		return paperdao.getPaperList(pageBean, parameter, pageIndex);
	}
	@Override
	public void endExam(Paper paper) {
		// TODO Auto-generated method stub
		 paperdao.updateExam(paper, "考试结束");
	}
	@Override
	public void createPaperRandom(Paper paper) {
		// TODO Auto-generated method stub
		paperdao.createPaperRandom(paper);
	}
	@Override
	public void startExam(List<PaperClass> paperClasses,Paper paper) {
		// TODO Auto-generated method stub
		paperdao.startExam(paperClasses);
		paperdao.updateExam(paper, "考试中");
	}
	

}
