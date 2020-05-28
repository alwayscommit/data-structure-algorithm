package com.learn.dsa.stack;

public class Stack<T extends Comparable<T>> {

	private Node<T> root;
	private int count;

	// O(1) time complexity
	public void push(T newData) {
		this.count++;

		if (this.root == null) {
			this.root = new Node<T>(newData);
		} else {
			Node<T> oldRoot = this.root;
			this.root = new Node<T>(newData);
			root.setNextNode(oldRoot);
		}

	}

	// O(1)
	public T pop() {
		T itemToPop = this.root.getData();
		this.root = this.root.getNextNode();
		this.count--;
		return itemToPop;
	}

	// O(1)
	public T peek() {
		return this.root.getData();
	}

	// O(1)
	public int size() {
		return this.count;
	}

	// O(1)
	public boolean isEmpty() {
		return this.root == null;
	}
}
