package com.learn.dsa.stack;

public class StackApplication {

	public static void main(String[] args) {
		
		Stack<Integer> intStack = new Stack<Integer>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);		
		intStack.push(4);
		
		System.out.println("Size :: " + intStack.size());
		
		System.out.println("Peek :: " + intStack.peek());
		
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		
		System.out.println("Size :: " + intStack.size());
		
		System.out.println("Peek :: " + intStack.peek());
		
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		
		
		
	}
	
}
