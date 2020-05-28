package com.learn.dsa.binarysearchtree.apps;

import com.learn.dsa.binarysearchtree.BinarySearchTree;

public class SumOfTreeNodes {
	
	public static void main(String[] args) {
		
		 BinarySearchTree<Integer> bstInt = new BinarySearchTree<Integer>();
		 
		 bstInt.insert(4);
		 bstInt.insert(2);
		 bstInt.insert(6);
		 bstInt.insert(1);
		 bstInt.insert(7);
		 
		System.out.println(bstInt.getSum(bstInt.getRoot()));
	}

}
