package com.learn.dsa.array;

public class LearnArray {

	public static void main(String[] args) {

		// Stored as one contiguous block in memory
		// That is why, we need to declare an array with fixed size, static length
		int[] intArray = new int[7]; // Not a dynamic data structure

		// Every element occupies same amount of space in memory
		intArray[0] = 20;
		intArray[1] = 30;
		intArray[2] = 40;
		intArray[3] = 50;
		intArray[4] = 60;
		intArray[5] = 70;
		intArray[6] = 80;
//		intArray[7] = 20; java.lang.ArrayIndexOutOfBoundsException

		// Array stores a bunch of object references to the actual objects.
		// Object references are of the same size

		// x + i * y
		// x = first element address,
		// i = i'th element
		// y = size of the object

		// - If the first index started with 1, then we'd get the wrong start address
		// for
		// the first element
		// - This is why arrays start with 0th index.

		for (int i = 0; i < intArray.length; i++) {
			System.out.println("Classic For-loop :: " + intArray[i]);
		}

		for (int i : intArray) {
			System.out.println("Not so classic but SMOOTH For-Loop :: " + i);
		}

		// Find index of an element, since we do not know.
		int elementIndex = 0;
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == 30) {
				elementIndex = i;
				break;
			}
		}
		System.out.println("20 is at index :: " + elementIndex);

		// Linear Time Complexity O(N) if we do not know where the element is, we have
		// to loop through all

	}

}
