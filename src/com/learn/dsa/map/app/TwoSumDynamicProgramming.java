package com.learn.dsa.map.app;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDynamicProgramming {

	private int[] numArray;
	
	private Map<Integer,Integer> hashMap;

	private int s;

	public TwoSumDynamicProgramming(int[] numArray, int s) {
		this.numArray = numArray;
		this.s = s;
		this.hashMap = new HashMap<Integer, Integer>();
	}

	public void solve() {

		for (int i = 0; i < numArray.length; i++) {

			int remainder = s - numArray[i];
			
			if(hashMap.containsValue(remainder)) {
				System.out.println("Solution: " + numArray[i] + " + " + remainder + " = " + s);
			}
			
			hashMap.put(i, numArray[i]);

		}

	}
}
