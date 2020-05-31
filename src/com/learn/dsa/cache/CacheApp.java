package com.learn.dsa.cache;

public class CacheApp {

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache();
		
		cache.put(0, "Aakash");
		cache.put(1, "Ranglani");
		cache.put(2, "Hello");
		cache.put(3, "World");
		cache.put(4, "How");
		cache.put(5, "Are");
		cache.put(6, "You?");
		
		System.out.println(cache.get(2));
		cache.show();
		System.out.println();
		
		System.out.println(cache.get(6));
		cache.show();
		System.out.println();
		
		System.out.println(cache.get(1));
		cache.show();
		System.out.println();
	}
}


