package com.learn.dsa.list;

public class LinkedListMainClass {
	public static void main(String[] args) {

		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.insert(1);
		myLinkedList.insert(2);
		myLinkedList.insert(3);
		myLinkedList.insert(4);
		myLinkedList.insert(5);

		myLinkedList.traverseList();

		System.out.println();
		System.out.println(myLinkedList.size());

		myLinkedList.remove(3);

		myLinkedList.traverseList();
		System.out.println();

		myLinkedList.reverse();

		myLinkedList.traverseList();
		System.out.println();

		Node<Integer> middleNode = myLinkedList.middleNode();
		System.out.println(middleNode.getData());

	}
}

class LinkedList<T extends Comparable<T>> implements List<T> {
	/*
	 * 1. Always insert in the front of the list, constant time O(1)
	 */

	private Node<T> head;
	private int size;

	// Insert at the beginning : O(1)
	public void insert(T data) {
		size++;
		if (head == null) {
			this.head = new Node<T>(data);
		} else {
			insertDataAtBeginning(data);
		}
	}

	// Insert at the end : O(N)
	private void insertDataAtEnd(T data, Node<T> node) {
		size++;
		if (node.getNextNode() != null) {
			insertDataAtEnd(data, node.getNextNode());
		} else {
			Node<T> newNode = new Node<T>(data);
			node.setNextNode(newNode);
		}
	}

	private void insertDataAtBeginning(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(head);// current head becomes next node to new node
		this.head = newNode;// new node becomes head
	}

	public void remove(T data) {

		if (this.head == null) {
			return;
		}

		--this.size;

		if (this.head.getData().compareTo(data) == 0) {
			this.head = this.head.getNextNode();
		} else {
			remove(data, head, head.getNextNode());
		}

	}

	private void remove(T dataToRemove, Node<T> currentNode, Node<T> nextNode) {
		while (nextNode != null) {
			if (nextNode.getData().compareTo(dataToRemove) == 0) {
				currentNode.setNextNode(nextNode.getNextNode());
				nextNode = null;
				return;
			} else {
				currentNode = nextNode;
				nextNode = nextNode.getNextNode();
			}
		}
	}

	public void traverseList() {
		if (this.head == null) {
			return;
		}
		Node<T> currentNode = this.head;

		while (currentNode != null) {
			System.out.print(currentNode + " -> ");
			currentNode = currentNode.getNextNode();
		}
		System.out.print("null");
		System.out.println("null");
	}

	public int size() {
		return this.size;
	}

	public void reverse() {

		Node<T> currentNode = this.head;
		Node<T> prevNode = null;
		Node<T> nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.getNextNode();// save current next node in nextNode pointer
			currentNode.setNextNode(prevNode);// flip next node
			prevNode = currentNode;
			currentNode = nextNode;
		}

		this.head = prevNode;

	}

	public Node<T> middleNode() {

		Node<T> singleJumpNode = this.head;
		Node<T> doubleJumpNode = this.head;

		while (doubleJumpNode.getNextNode() != null && doubleJumpNode.getNextNode().getNextNode() != null) {
			doubleJumpNode = doubleJumpNode.getNextNode().getNextNode();
			singleJumpNode = singleJumpNode.getNextNode();
		}

		return singleJumpNode;
	}

}

interface List<T extends Comparable<T>> {

	public void insert(T data);

	public void remove(T data);

	public void traverseList();

	public int size();

	public void reverse();

	public Node<T> middleNode();
	

}

class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> nextNode;
	private Node<T> prevNode;

	public Node<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

}
