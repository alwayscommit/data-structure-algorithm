package com.learn.dsa.binarysearchtree.apps;

import com.learn.dsa.binarysearchtree.BinarySearchTree;
import com.learn.dsa.binarysearchtree.Node;

public class CompareBST<T extends Comparable<T>> {

	public boolean compareTrees(Node<T> node1, Node<T> node2) {

		// base case
		if (node1 == null || node2 == null) {
			return node1 == node2;
		}

		if (node1.getData().compareTo(node2.getData()) != 0) {
			return false;
		}

		return compareTrees(node1.getLeftChild(), node2.getLeftChild())
				&& compareTrees(node1.getRightChild(), node2.getRightChild());

	}
	
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> bstInt = new BinarySearchTree<Integer>();
		
		bstInt.insert(1);
		bstInt.insert(2);
		bstInt.insert(3);
		bstInt.insert(4);
		bstInt.insert(5);
		
		BinarySearchTree<Integer> bstInt2 = new BinarySearchTree<Integer>();
		bstInt2.insert(1);
		bstInt2.insert(2);
		bstInt2.insert(5);
		bstInt2.insert(4);
		bstInt2.insert(5);
		
		CompareBST<Integer> intCompare = new CompareBST<Integer>();
		
		System.out.println(intCompare.compareTrees(bstInt.getRoot(), bstInt2.getRoot()));
		
	}

}
