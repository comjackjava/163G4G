package com.qhit.lh.g4.rcc.exam;

import org.junit.Test;

import com.qhit.lh.g4.rcc.exam.common.utils.RandomUtil;

public class RandomTest {

	@Test
	public void getRandom(){
		int[] qs = RandomUtil.randomCommon(1,2,1);
		for (int i = 0; i < qs.length; i++) {
			System.out.println(qs[i]);
		}
	}
}
