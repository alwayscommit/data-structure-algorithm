package com.learn.dsa.stack;

import java.util.Stack;

public class StackJDK {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		for(Integer i : stack) {
			System.out.println(i);
		}
		System.out.println(stack.peek());
	}

}
