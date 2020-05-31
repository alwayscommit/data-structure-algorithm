package com.learn.dsa.map.chaining;

public class HashMapApp {
	
	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable();
		
		hashTable.put(1, 100);
		hashTable.put(2, 200);
		hashTable.put(3, 300);
		hashTable.put(4, 400);
		
		System.out.println(hashTable.get(4));
		
		
		
	}

}
