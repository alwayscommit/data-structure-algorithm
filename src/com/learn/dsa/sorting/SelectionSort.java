package com.learn.dsa.sorting;

public class SelectionSort {

	/*
	 * 1. Since array is not sorted, assign the last index as unsortedIndex
	 * 2. Assign first index element to be the largest
	 * 3. In every iteration from first index to unsortedIndex, we find largest value by comparing with assumed largest value
	 * 4. At the end of first iteration, swap the largest index value with the unsortedIndex
	 * 5. Reduce the unsorted index by 1, as the last element is sorted
	 * 6. Repeat
	 */
	
	public static void main(String[] args) {

		int[] intArray = { 80, 30, -10, 100, 20, 1, -33, 200 };

		for(int unsortedIndex = intArray.length-1; unsortedIndex>0; unsortedIndex--) {
			int largest = 0;
			
			//need to compare every element with largest
			for (int i = 0; i <= unsortedIndex; i++) {
				if (intArray[i] > intArray[largest]) {
					largest = i;
				}
			}
			
			swap(intArray, largest, unsortedIndex);
		}
		
		for (int i : intArray) {
			System.out.println("Unsorted :: " + i);
		}
		
		

	}

	public static void swap(int[] array, int firstElement, int secondElement) {

		// stable sort condition
		if (firstElement == secondElement) {
			return;
		}

		int temp = array[firstElement];
		array[firstElement] = array[secondElement];
		array[secondElement] = temp;
		return;
	}

}
