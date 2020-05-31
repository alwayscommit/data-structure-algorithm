package com.learn.dsa.map.linearprobing;

public class HashTable {

	private HashItem[] hashTable;

	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	public int get(int key) {
		int generatedArrayIndex = hash(key);

		while (hashTable[generatedArrayIndex] != null && hashTable[generatedArrayIndex].getKey() != key) {
			generatedArrayIndex = (generatedArrayIndex + 1) % Constants.TABLE_SIZE;
		}

		if (hashTable[generatedArrayIndex] == null) {
			return -1;
		} else {
			return hashTable[generatedArrayIndex].getValue();
		}

	}

	public void put(int key, int value) {
		int generatedIndex = hash(key);

		System.out.println("put() method called with value " + value + " - generatedIndex " + generatedIndex);

		while (hashTable[generatedIndex] != null) {
			generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
			System.out.println("Collision -> nextIndex : " + generatedIndex);
		}

		System.out.println("Inserted finally with index..." + generatedIndex);
		hashTable[generatedIndex] = new HashItem(key, value);
	}

	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
//		return 1; //test collision
	}

}
