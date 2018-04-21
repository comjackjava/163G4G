/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.questions_management.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qhit.lh.g4.perfact.exam.common.utils.RandomUtil;
import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;

/**
 * @author 万曦晖
 *TODO
 *2018年1月12日上午9:00:20
 */
public class RandomQuestionsUtils {
	public static WrittenTest writtenTest;
	public static Set<WrittenTest> randomAllQuestions(
			List<WrittenTest> listRE,
			List<WrittenTest> listRN,
			List<WrittenTest> listRD,
			List<WrittenTest> listCE,
			List<WrittenTest> listCN,
			List<WrittenTest> listCD,
			int radioEasy,int radioNormal,int radioDiff,
			int cbEasy,int cbNormal,int cbDiff
			){
		Set<WrittenTest> lisQuestions = new HashSet<>();

		randomQuestions(listRE,radioEasy,lisQuestions);
		randomQuestions(listRN,radioNormal,lisQuestions);
		randomQuestions(listRD,radioDiff,lisQuestions);
		randomQuestions(listCE,cbEasy,lisQuestions);
		randomQuestions(listCN,cbNormal,lisQuestions);
		randomQuestions(listCD,cbDiff,lisQuestions);

		return lisQuestions;
	}
	/**
	 * @param listCD
	 * @param cbDiff
	 * @param lisQuestions
	 */
	public static void randomQuestions(List<WrittenTest> list, int num, Set<WrittenTest> lisQuestions){
		//从数据集合中随机获取不同的索引
		int[] questions = RandomUtil.randomCommon(1, list.size(), num);
		System.out.println(questions.length);
		for(int i=0;i<questions.length;i++){
			System.out.println(list.get(questions[i]-1).getQid());
			//获取试题
			writtenTest = list.get(questions[i]-1);
			lisQuestions.add(writtenTest);
		}
	}
}
