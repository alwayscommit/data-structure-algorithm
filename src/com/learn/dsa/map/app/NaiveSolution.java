package com.learn.dsa.map.app;

public class NaiveSolution {

	private int[] numArray;

	private int s;

	public NaiveSolution(int[] numArray, int s) {
		this.numArray = numArray;
		this.s = s;
	}

	// O(n^2)
	public void solve() {

		for (int i = 0; i < numArray.length; i++) {

			for (int j = 0; j < numArray.length; j++) {

				if(numArray[i] + numArray[j] == s) {
					System.out.println("Solution: " + numArray[i]+"+"+numArray[j]+"="+s);
				}
				
			}

		}

	}

}
