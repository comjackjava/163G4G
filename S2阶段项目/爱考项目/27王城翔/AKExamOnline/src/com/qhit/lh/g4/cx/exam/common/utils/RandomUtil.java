package com.qhit.lh.g4.cx.exam.common.utils;

import java.util.HashSet;
import java.util.Random;

public class RandomUtil {

	/** 
	 * 随机指定范围内N个不重复的数 
	 * �?��单最基本的方�?
	 * @param min 指定范围�?���?,包含
	 * @param max 指定范围�?���?,不包�?
	 * @param n 随机数个�?
	 */  
	public static int[] randomCommon(int min, int max, int n){
		if (n > (max - min + 1) || max < min) {  
			return null;  
		}  
		int[] result = new int[n];  
		int count = 0;  
		while(count < n) {  
			int num = (int) (Math.random() * (max - min)) + min;  
			boolean flag = true;  
			for (int j = 0; j < n; j++) {  
				if(num == result[j]){  
					flag = false;  
					break;  
				}  
			}  
			if(flag){  
				result[count] = num;  
				count++;  
			}  
		}  
		return result;  
	}  

	/** 
	 * 随机指定范围内N个不重复的数 
	 * 利用HashSet的特征，只能存放不同的�? 
	 * @param min 指定范围�?���?
	 * @param max 指定范围�?���?
	 * @param n 随机数个�?
	 * @param HashSet<Integer> set 随机数结果集 
	 */  
	public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
		if (n > (max - min + 1) || max < min) {  
			return;  
		}  
		for (int i = 0; i < n; i++) {  
			// 调用Math.random()方法  
			int num = (int) (Math.random() * (max - min)) + min;  
			set.add(num);// 将不同的数存入HashSet�? 
		}  
		int setSize = set.size();  
		// 如果存入的数小于指定生成的个数，则调用�?归再生成剩余个数的随机数，如此循环，直到达到指定大小  
		if (setSize < n) {  
			randomSet(min, max, n - setSize, set);// 递归  
		}  
	}

	/** 
	 * 随机指定范围内N个不重复的数 
	 * 在初始化的无重复待�?数组中随机产生一个数放入结果中， 
	 * 将待选数组被随机到的数，用待选数�?len-1)下标对应的数替换 
	 * 然后从len-2里随机产生下�?��随机数，如此类推 
	 * @param max  指定范围�?���?
	 * @param min  指定范围�?���?
	 * @param n  随机数个�?
	 * @return int[] 随机数结果集 
	 */  
	public static int[] randomArray(int min,int max,int n){  
		int len = max-min+1;  

		if(max < min || n > len){  
			return null;  
		}  

		//初始化给定范围的待�?数组  
		int[] source = new int[len];  
		for (int i = min; i < min+len; i++){  
			source[i-min] = i;  
		}  

		int[] result = new int[n];  
		Random rd = new Random();  
		int index = 0;  
		for (int i = 0; i < result.length; i++) {  
			//待�?数组0�?len-2)随机�?��下标  
			index = Math.abs(rd.nextInt() % len--);  
			//将随机到的数放入结果�? 
			result[i] = source[index];  
			//将待选数组中被随机到的数，用待�?数组(len-1)下标对应的数替换  
			source[index] = source[len];  
		}  
		return result;  
	}
}
