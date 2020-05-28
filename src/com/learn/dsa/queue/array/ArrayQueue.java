package com.learn.dsa.queue.array;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {

	private T[] dataQueue;
	private int front;
	private int back;

	public ArrayQueue(int capacity) {
		dataQueue = (T[]) new Object[capacity];
	}

	public void add(T t) {
//		if (back == dataQueue.length) {
		
		//making it circular	
		if(size()==dataQueue.length-1) {
			T[] newQueue = (T[]) new Object[2 * dataQueue.length];
			System.arraycopy(dataQueue, 0, newQueue, 0, dataQueue.length);
			dataQueue = newQueue;
		}
		dataQueue[back] = t;
		
		if(back < dataQueue.length-1) {
			back++;
		} else {
			back=0;
		}
		
		
	}

	public T remove() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}

		T dataToRemove = dataQueue[front];
		dataQueue[front] = null;
		front++;
		if (size() == 0) {
			front = 0;
			back = 0;
		}
		
		return dataToRemove;
	}
	
	public T peek() {
		if(size()==0) {
			throw new NoSuchElementException();
		}
		return dataQueue[front];
	}

	public int size() {
		return back - front;
	}

	public void printQueue() {
		for(int i=front; i<back; i++) {
			System.out.println(dataQueue[i]);
		}
	}
}
