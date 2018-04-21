package com.qhit.lh.g4.perfact.exam.examinationpaper_management.service;

import java.util.Map;

import com.qhit.lh.g4.perfact.exam.common.bean.PageBean;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.bean.Paper;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.dao.PaperDao;
import com.qhit.lh.g4.perfact.exam.examinationpaper_management.dao.impl.PaperDaoImpl;

public class PaperServiceImpl implements PaperService {
	private PaperDao paperDao = new PaperDaoImpl();
	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		// TODO Auto-generated method stub
		return paperDao.getPaperList(pageBean, parameter, pageIndex);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.examinationpaper_management.service.PaperService#endExam(com.qhit.lh.g4.perfact.exam.examinationpaper_management.bean.Paper)
	 */
	@Override
	public void endExam(Paper paper) {
		// TODO Auto-generated method stub
		paperDao.endExam(paper);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.perfact.exam.examinationpaper_management.service.PaperService#createPaperRandom(com.qhit.lh.g4.perfact.exam.examinationpaper_management.bean.Paper)
	 */
	@Override
	public void createPaperRandom(Paper paper) {
		// TODO Auto-generated method stub
		paperDao.createPaperRandom(paper);
	}

}
