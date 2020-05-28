package com.learn.dsa.queue.array;

public class ArrayQueueApp {
	
	public static void main(String[] args) {
		
		ArrayQueue<Integer> intQueue = new ArrayQueue<Integer>(10);
		intQueue.add(1);
		intQueue.add(2);
		intQueue.add(3);
		intQueue.add(4);

		System.out.println("Queue");
		intQueue.printQueue();
		
		int removedInt = intQueue.remove();
		System.out.println("Removed :: " + removedInt);
		
		System.out.println("Queue");
		intQueue.printQueue();
		
		System.out.println("Peek :: " + intQueue.peek());
	}

}
