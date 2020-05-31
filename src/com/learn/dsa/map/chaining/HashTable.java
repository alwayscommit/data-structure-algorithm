package com.learn.dsa.map.chaining;

public class HashTable {

	private HashItem[] hashTable;
	
	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	public int get(int key) {
		int generatedArrayIndex = hash(key);
		
		if(hashTable[generatedArrayIndex]==null) {
			return -1;
		} else {
			
			HashItem hashItem = hashTable[generatedArrayIndex];
			
			while(hashItem!=null && hashItem.getKey()!=key) {
				hashItem = hashItem.getNextHashItem();
			}
			
			if(hashItem==null) {
				return -1;
			} else {
				return hashItem.getValue();
			}
			
		}
		
		
	}

	public void put(int key, int value) {
		int hashArrayIndex = hash(key);

		if (hashTable[hashArrayIndex] == null) {
			System.out.println("Inserting element without any collision...");
			hashTable[hashArrayIndex] = new HashItem(key, value);
		} else {
			// collision

			System.out.println("Collision with key " + key);
			HashItem hashItem = hashTable[hashArrayIndex];

			while (hashItem.getNextHashItem() != null) {
				System.out.println("Collision occurred again...");
				hashItem = hashItem.getNextHashItem();
			}

			System.out.println("Found a place after collision...");
			hashItem.setNextHashItem(new HashItem(key, value));

		}

	}

	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
//		return 1; //test collision
	}

}
