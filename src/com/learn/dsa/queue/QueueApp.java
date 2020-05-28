package com.learn.dsa.queue;

public class QueueApp {
	
	//FIFO
	public static void main(String[] args) {
		
		Queue<Integer> myQueue = new Queue<Integer>();
		
		myQueue.enqueue(10);
		myQueue.enqueue(20);
		
		System.out.println(myQueue.size());
		
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		
		System.out.println(myQueue.size());
	}

}
