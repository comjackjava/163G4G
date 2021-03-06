package com.qhit.lh.g4.jack.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.jack.exam.common.bean.PageBean;
import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.sjgl.bean.Paper;
import com.qhit.lh.g4.jack.exam.sjgl.bean.PaperClass;

public interface Paperservice {
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
	public Paper  getPointsTestList( Map<String, Object> parameter);
	public void endExam(Paper paper);
	public void createPaperRandom(Paper paper);
	public void startExam(List<PaperClass> paperClasses,Paper paper);
	public void createByChoose(Paper paper);
}
