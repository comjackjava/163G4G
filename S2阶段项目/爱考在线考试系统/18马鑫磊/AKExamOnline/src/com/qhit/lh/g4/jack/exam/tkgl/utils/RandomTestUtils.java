package com.qhit.lh.g4.jack.exam.tkgl.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qhit.lh.g4.jack.exam.common.utils.RandomUtil;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;

public class RandomTestUtils {
	private static WrittenTest WrittenTest;
	private static Set<WrittenTest> lisQuestions = new HashSet<WrittenTest>();
	

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
			System.out.println("**************************************");
			System.out.println("本次接收到的参数全部在以下公示：");
			System.out.println("listRE"+listRE.size());
			System.out.println("listRN"+listRN.size());
			System.out.println("listRD"+listRD.size());
			System.out.println("listCE"+listCE.size());
			System.out.println("listCN"+listCN.size());
			System.out.println("listCD"+listCD.size());
			System.out.println("radioEasy"+radioEasy);
			System.out.println("radioNormal"+radioNormal);
			System.out.println("radioDiff"+radioDiff);
			System.out.println("cbEasy"+cbEasy);
			System.out.println("cbNormal"+cbNormal);
			System.out.println("cbDiff"+cbDiff);
		System.out.println("**************************************");
		

		randomQuestions(listRE,radioEasy,lisQuestions);

		randomQuestions(listRN,radioNormal,lisQuestions);

		randomQuestions(listRD,radioDiff,lisQuestions);

		randomQuestions(listCE,cbEasy,lisQuestions);

		randomQuestions(listCN,cbNormal,lisQuestions);

		randomQuestions(listCD,cbDiff,lisQuestions);

		

		return lisQuestions;

	}

	

	public static void randomQuestions(List<WrittenTest> list, int num, Set<WrittenTest> lisQuestions){

		//从数据集合中随机获取不同的索引

		int[] questions = RandomUtil.randomCommon(1, list.size(), num);

		System.out.println("questioins的大小："+questions.length);

		for(int i=0;i<questions.length;i++){

			System.out.println("本次获取第"+i+"个试题题号"+list.get(questions[i]-1).getQid());
			System.out.println("本次获取第"+i+"个试题完毕");

			//获取试题

			WrittenTest = list.get(questions[i]-1);

			lisQuestions.add(WrittenTest);

		}

	}

}