package com.learn.dsa.stack.array;

public class Stack<T> {

	private T[] stack;
	private int numOfItems;

	public Stack() {
		this.stack = (T[]) new Object[1];
	}

	public void push(T newData) {
		if (numOfItems == this.stack.length) {
			resize(2 * this.stack.length);
		}

		this.stack[numOfItems] = newData;
		numOfItems++;
	}
	
	public T peek() {
		return this.stack[numOfItems-1];
	}

	public T pop() {

		T itemToPop = this.stack[--numOfItems];

		//best practice
		if (numOfItems > 0 && numOfItems == this.stack.length / 4) {
			resize(this.stack.length / 2);
		}

		return itemToPop;

	}

	public boolean isEmpty() {
		return this.numOfItems == 0;
	}

	public int size() {
		return this.numOfItems;
	}

	private void resize(int newCapacity) {
		T[] stackCopy = (T[]) new Object[newCapacity];

		for (int i = 0; i < numOfItems; i++) {
			stackCopy[i] = this.stack[i];
		}

		this.stack = stackCopy;

	}

}
