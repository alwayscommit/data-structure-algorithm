package com.learn.dsa.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	public void insert(T data) {

		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}

	}

	public void traverse() {

		if (root != null) {
			inOrderTraversal(root);
		}
	}

	private void inOrderTraversal(Node<T> root) {
		if (root.getLeftChild() != null) {
			inOrderTraversal(root.getLeftChild());
		}

		System.out.print(root + " --> ");

		if (root.getRightChild() != null) {
			inOrderTraversal(root.getRightChild());
		}
	}

	private void insertNode(T data, Node<T> root) {

		if (data.compareTo(root.getData()) < 0) {
			if (root.getLeftChild() != null) {
				insertNode(data, root.getLeftChild());
			} else {
				Node<T> newNode = new Node<T>(data);
				root.setLeftChild(newNode);
			}
		} else {
			if (root.getRightChild() != null) {
				insertNode(data, root.getRightChild());
			} else {
				Node<T> newNode = new Node<T>(data);
				root.setRightChild(newNode);
			}
		}

	}

	public void delete(T data) {

		if (root != null) {
			root = delete(root, data);
		}

	}

	private Node<T> delete(Node<T> root, T data) {

		if (data.compareTo(root.getData()) < 0) {
			root.setLeftChild(delete(root.getLeftChild(), data));
		} else if (data.compareTo(root.getData()) > 0) {
			root.setRightChild(delete(root.getRightChild(), data));
		} else {
			if (root.getLeftChild() == null && root.getRightChild() == null) {
				System.out.println("removing leaf node...");
				return null;
			}

			if (root.getLeftChild() == null) {
				System.out.println("Removing right child...");
				Node<T> tempNode = root.getRightChild();
				root = null;
				return tempNode;
			} else if (root.getRightChild() == null) {
				System.out.println("Removing left child...");
				Node<T> tempNode = root.getLeftChild();
				root = null;
				return tempNode;
			}

			Node<T> tempNode = getPredecessor(root.getLeftChild());

			root.setData(tempNode.getData());
			root.setLeftChild(delete(root.getLeftChild(), tempNode.getData()));
		}

		return root;
	}

	private Node<T> getPredecessor(Node<T> root) {

		if (root.getRightChild() != null) {
			return getPredecessor(root.getRightChild());
		}

		return root;
	}

	public T getMax() {
		if (root == null) {
			return null;
		}
		return getMaxNode(root);
	}

	private T getMaxNode(Node<T> root) {
		if (root.getRightChild() != null) {
			return getMaxNode(root.getRightChild());
		}

		return root.getData();
	}

	public T getMin() {
		if (root == null) {
			return null;
		}
		return getMinNode(root);
	}

	private T getMinNode(Node<T> root) {
		if (root.getLeftChild() != null) {
			return getMinNode(root.getLeftChild());
		}

		return root.getData();
	}

	public Node<T> getRoot() {
		return root;
	}

	public Node<T> getKSmallest(Node<T> node, int k) {

		int n = treeSize(node.getLeftChild()) + 1;
		if (n == k) {
			return node;
		}
		if (n > k) {
			return getKSmallest(node.getLeftChild(), k);
		}
		if (n < k) {
			return getKSmallest(node.getRightChild(), k - n);
		}
		return null;
	}

	public int treeSize(Node<T> node) {

		if (node == null) {
			return 0;
		}

		return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
	}
	
	public int getSum(Node<T> node) {
		
		int sum = 0;
		int leftSum = 0;
		int rightSum = 0;
		
		if(node==null) {
			return 0;
		}
		
		leftSum = getSum(node.getLeftChild());
		rightSum = getSum(node.getRightChild());
		
		sum = ((Integer) node.getData()) + leftSum + rightSum;
		
		return sum;
	}

}
