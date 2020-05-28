package com.learn.dsa.stack;

public class MaxItemInStack {

	private Stack<Integer> mainStack;
	private Stack<Integer> maxStack;

	public MaxItemInStack() {
		this.mainStack = new Stack<Integer>();
		this.maxStack = new Stack<Integer>();
	}

	public void push(int number) {

		// empty stack
		if (mainStack.size() == 0) {
			mainStack.push(number);
			maxStack.push(number);
			return;
		} else {
			mainStack.push(number);
			if (number > maxStack.peek()) {
				maxStack.push(number);
			} else {
				maxStack.push(maxStack.peek());
			}
		}

	}

	public int pop() {
		maxStack.pop();
		return mainStack.pop();
	}

	public int getMax() {
		return maxStack.peek();
	}

	public static void main(String[] args) {
		MaxItemInStack maxFinder = new MaxItemInStack();
		maxFinder.push(10);
		maxFinder.push(-10);
		maxFinder.push(100);
		maxFinder.push(1000);
		maxFinder.push(-1010);
		maxFinder.push(999);

		System.out.println(maxFinder.getMax());
		
		maxFinder.pop();
		maxFinder.pop();
		maxFinder.pop();
		
		System.out.println(maxFinder.getMax());
		
	}

}
