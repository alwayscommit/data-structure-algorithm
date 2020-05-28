package com.learn.dsa.binarysearchtree.apps;

import com.learn.dsa.binarysearchtree.BinarySearchTree;

public class KthSmallestItem {
	
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		
		intTree.insert(5);
		intTree.insert(4);
		intTree.insert(6);
		
		System.out.println(intTree.treeSize(intTree.getRoot()));
		
		System.out.println(intTree.getKSmallest(intTree.getRoot(), 1));
		
	}

}
