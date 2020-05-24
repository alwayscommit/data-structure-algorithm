package com.learn.dsa.sorting;

public class BubbleSort {
	
	/*
	 * 1. Put the last index of the array as unsortedIndex as nothing is sorted yet
	 * 2. Start from left to right, i = 0
	 * 3. Compare i and i + 1
	 * 4. Swap if value @ i > value @ i+1
	 * 5. Continue till comparison reaches last index - 1 and last index, swap if needed
	 * 6. largest element will reach the end of the list
	 * 7. lock the last index by decreasing assumed sorted index by 1
	 * 8. repeat
	 */

	public static void main(String[] args) {

		// In-Place Algorithm
		// Time complexity :: O(N-Square) - Quadratic
		// Algorithm degrades quickly

		int[] intArray = { 80, 30, -10, 100, 20, 1, -33, 200 };

		for(int i : intArray) {
			System.out.println("Unsorted :: " + i);
		}
		
		//Two loops = n*n = quadratic
		for (int unsortedIndex = intArray.length - 1; unsortedIndex > 0; unsortedIndex--) {
			for (int i = 0; i < unsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
		}
		
		for(int i : intArray) {
			System.out.println("Sorted :: " + i);			
		}

	}

	public static void swap(int[] array, int firstElement, int secondElement) {
		
		//stable sort condition
		if (firstElement == secondElement) {
			return;
		}

		int temp = array[firstElement];
		array[firstElement] = array[secondElement];
		array[secondElement] = temp;
		return;
	}

}
