package com.learn.dsa.sorting;

public class ShellSort {

	public static void main(String[] args) {

		// gap value = array.length/2

		int[] intArray = { 80, 30, -10, 100, 20, 1, -33, 200 };

		for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < intArray.length; i++) {

				int newElement = intArray[i];
				int j = i;

				while (j >= gap && intArray[j - gap] > newElement) {
					intArray[j] = intArray[j - gap];
					j -= gap;
				}

				intArray[j] = newElement;
			}

		}

		for (int i : intArray) {
			System.out.println("Sorted :: " + i);
		}

	}

}
