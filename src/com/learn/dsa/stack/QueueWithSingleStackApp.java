package com.learn.dsa.stack;

public class QueueWithSingleStackApp {
	
	public static void main(String[] args) {
		QueueWithSingleStack queue = new QueueWithSingleStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		System.out.println(queue.dequeue());
		
	}
	
	
	
}

class QueueWithSingleStack {
	private Stack<Integer> stack;

	public QueueWithSingleStack() {
		this.stack = new Stack<Integer>();
	}

	public void enqueue(int number) {
		this.stack.push(number);
	}

	public int dequeue() {
		if(stack.size()==1) {
			return stack.pop();
		}
		
		int item = stack.pop();
		
		int lastDequeuedItem = dequeue();
		
		enqueue(item);
		
		return lastDequeuedItem;
	}
}
