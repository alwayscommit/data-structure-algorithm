package com.learn.dsa.stack;

class QueueWithStack {

	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;

	public QueueWithStack() {
		this.enqueueStack = new Stack<Integer>();
		this.dequeueStack = new Stack<Integer>();
	}

	public void enqueue(int number) {
		this.enqueueStack.push(number);
	}

	public int dequeue() {

		if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Stacks are empty....");
		}

		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.pop();
	}
}

public class QueueWithStackApp {

	public static void main(String[] args) {

		QueueWithStack queueStack = new QueueWithStack();

		queueStack.enqueue(1);
		queueStack.enqueue(2);
		queueStack.enqueue(3);
		queueStack.enqueue(4);
		
		
		System.out.println(queueStack.dequeue());
		
		queueStack.enqueue(5);
		
		System.out.println(queueStack.dequeue());
		System.out.println(queueStack.dequeue());
		System.out.println(queueStack.dequeue());
		System.out.println(queueStack.dequeue());

	}

}
