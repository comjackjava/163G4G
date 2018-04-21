package com.qhit.lh.g4.syw.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.g4.syw.exam.common.bean.PageBean;
import com.qhit.lh.g4.syw.exam.sjgl.bean.Paper;

public interface PaperService {
	
	/**
	 * @param paer
	 * 随机组卷
	 */
	public void createPaperRandom(Paper paper);
	
	/**
	 * @param paper
	 * 结束考试
	 */
	public void endExam(Paper paper);

	/**
	 * @param parameter
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
}
