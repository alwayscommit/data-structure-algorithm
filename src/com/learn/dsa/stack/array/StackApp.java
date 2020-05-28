package com.learn.dsa.stack.array;

public class StackApp {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		System.out.println("PEEK :: " + stack.peek());
		stack.push(2);
		System.out.println("PEEK :: " + stack.peek());
		System.out.println("POP :: " + stack.pop());
		System.out.println("PEEK :: " + stack.peek());
	}

}
