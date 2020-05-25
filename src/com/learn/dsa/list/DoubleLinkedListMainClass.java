package com.learn.dsa.list;

public class DoubleLinkedListMainClass {
	public static void main(String[] args) {

		DoubleLinkedList<Integer> myLinkedList = new DoubleLinkedList<Integer>();
		myLinkedList.insert(1);
		myLinkedList.insert(2);
		myLinkedList.insert(3);
		myLinkedList.insert(4);
		myLinkedList.insert(5);

		myLinkedList.traverseList();

		myLinkedList.insertDataAtEnd(10);

		myLinkedList.traverseList();

		myLinkedList.remove(5);

		myLinkedList.traverseList();

		DoubleLinkedList<Integer> mySortedLinkedList = new DoubleLinkedList<Integer>();
		mySortedLinkedList.insertSorted(1);
		mySortedLinkedList.insertSorted(10);
		mySortedLinkedList.insertSorted(-10);
		mySortedLinkedList.insertSorted(100);
		mySortedLinkedList.insertSorted(1000);
		mySortedLinkedList.insertSorted(-1000);
		mySortedLinkedList.traverseList();
		mySortedLinkedList.traverseListFromBehind();
	}
}

class DoubleLinkedList<T extends Comparable<T>> implements List<T> {
	/*
	 * 1. Always insert in the front of the list, constant time O(1)
	 */

	private Node<T> head;
	private Node<T> tail;
	private int size;

	// Insert at the beginning : O(1) :: Default
	public void insert(T data) {
		size++;
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			head.setPrevNode(newNode);// current head's previous node was null, now it'll be newNode
			newNode.setNextNode(head);// newNode's nextNode was null, now it'll be the current head
			this.head = newNode;// the newNode becomes the current head
		}
	}

	public void insertSorted(T data) {
		Node<T> newNode = new Node<T>(data);
		// empty list
		if (head == null) {
			insert(data);
			return;
		}
		
		//new element smaller than head
		if(head.getData().compareTo(data)==1) {
			insert(data);
			return;
		}
		
		//single element in the list and new element greater than head
		if(head.getNextNode()==null) {
			insertDataAtEnd(data);
			return;
		}

		Node<T> nextNode = head.getNextNode();
		while (nextNode != null) {
			// nextNode greater than new node
			if (nextNode.getData().compareTo(data) == 1) {
				Node<T> prev = nextNode.getPrevNode();
				prev.setNextNode(newNode);
				newNode.setNextNode(nextNode);
				newNode.setPrevNode(prev);
				nextNode.setPrevNode(newNode);
				break;
			}
			//end of the list
			if(nextNode.getNextNode()==null) {
				insertDataAtEnd(data);
				break;
			} else {
				nextNode = nextNode.getNextNode();
			}
		}
	}

	// Insert at the end : O(N)
	public void insertDataAtEnd(T data) {
		size++;
		Node<T> newNode = new Node<T>(data);
		if (tail == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			tail.setNextNode(newNode);
			newNode.setPrevNode(tail);
			this.tail = newNode;
		}
	}

	public void remove(T data) {

		if (this.head == null) {
			return;
		}

		--this.size;

		// front of the list
		if (this.head.getData().compareTo(data) == 0) {
			this.head = this.head.getNextNode();
			this.head.setPrevNode(null);
		} else {
			remove(data, head.getNextNode());
		}

	}

	private void remove(T dataToRemove, Node<T> currentNode) {
		while (currentNode != null) {
			if (currentNode.getData().compareTo(dataToRemove) == 0) {

				Node<T> prevNode = currentNode.getPrevNode();
				prevNode.setNextNode(currentNode.getNextNode());
				Node<T> nextNode = currentNode.getPrevNode();
				nextNode.setPrevNode(currentNode.getPrevNode());
				currentNode = null;

			} else {
				currentNode = currentNode.getNextNode();
			}
		}
	}

	public void traverseList() {
		if (this.head == null) {
			return;
		}
		Node<T> currentNode = this.head;

		while (currentNode != null) {
			System.out.print(currentNode + " <-> ");
			currentNode = currentNode.getNextNode();
		}
		System.out.print("null");
		System.out.println("");
	}

	public void traverseListFromBehind() {
		if (this.tail == null) {
			return;
		}
		Node<T> currentNode = this.tail;

		while (currentNode != null) {
			System.out.print(currentNode + " <-> ");
			currentNode = currentNode.getPrevNode();
		}
		System.out.print("null");
		System.out.println("");
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
			prevNode = currentNode;//update pointer
			currentNode = nextNode;//update pointer
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
