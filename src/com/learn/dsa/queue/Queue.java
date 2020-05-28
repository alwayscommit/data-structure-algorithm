package com.learn.dsa.queue;

public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;

	public boolean isEmpty() {
		return this.firstNode == null;
	}

	public int size() {
		return this.count;
	}

	// O(1)
	public void enqueue(T newData) {
		this.count++;

		if (isEmpty()) {
			firstNode = new Node<T>(newData);
			lastNode = firstNode;
		} else {
			Node<T> oldLastNode = this.lastNode;
			this.lastNode = new Node<T>(newData);
			this.lastNode.setNextNode(null);
			oldLastNode.setNextNode(lastNode);
		}

	}

	// O(1)
	public T dequeue() {
		
		if (isEmpty()) {
			return null;
		}
		
		this.count--;

		T dataToDeque = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();

		if (isEmpty()) {
			this.lastNode = null;
		}

		return dataToDeque;
	}
}
