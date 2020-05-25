package com.learn.dsa.sorting;

public class InsertionSort {
	
	/*
	 * 1. Assume Index 0 is sorted array with one element.
	 * 2. Loop from unsortedIndex = 1 to length of array - 1
	 * 3. Store this unsortedIndex element as a newElement
	 * 4. Another for-loop which starts from right to left inside sorted array
	 * 5. It keeps going towards the left till we find a value greater than newElement
	 * 6. Put the greater value on the left side to the right side value
	 * 7. put the new element value in i
	 * 
	 */
	
	public static void main(String[] args) {
		
		int[] intArray = { 80, 30, -10, 100, 20, 1, -33, 200 };
		
		for(int unsortedIndex = 1; unsortedIndex<intArray.length; unsortedIndex++) {

			int newElement = intArray[unsortedIndex];
			int i;
			
			for(i=unsortedIndex; i>0 && intArray[i-1]>newElement; i--) {
				intArray[i] = intArray[i-1];
			}
			
			intArray[i] = newElement;
		}
		
		for (int i : intArray) {
			System.out.println("Sorted :: " + i);
		}
		
	}

}
