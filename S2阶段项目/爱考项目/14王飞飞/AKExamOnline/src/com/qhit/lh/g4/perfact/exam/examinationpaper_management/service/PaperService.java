package com.qhit.lh.g4.perfact.exam.examinationpaper_management.service;

import java.util.Map;

import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.bean.Paper;

public interface PaperService {
	/**
	 * @param parameter
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);

	/**
	 * @param paper
	 * 结束考试
	 */
	public void endExam(Paper paper);
	
	/**
	 * @param paper
	 * 随机组卷
	 */
	public void createPaperRandom(Paper paper);
}
