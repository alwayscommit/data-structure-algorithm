package com.learn.dsa.map.app;

public class TwoSumApp {
	public static void main(String[] args) {

		NaiveSolution naive = new NaiveSolution(new int[] { 3, 5, 2, -4, 8, 11 }, 7);
		naive.solve();

		System.out.println();
		
		TwoSumDynamicProgramming dynamicProgramming = new TwoSumDynamicProgramming(new int[] { 3, 5, 2, -4, 8, 11 }, 7);
		dynamicProgramming.solve();
	}
}
