package com.learn.dsa.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int size;
	private Map<Integer, Node> nodeMap;
	private DoublyLinkedList cacheLinkedList;

	public LRUCache() {
		this.nodeMap = new HashMap<Integer, Node>();
		this.cacheLinkedList = new DoublyLinkedList();
	}

	public void put(int id, String data) {

		// Node already present, update it with new value and bring it to front
		if (nodeMap.containsKey(id)) {
			Node node = this.nodeMap.get(id);
			node.setData(data);
			// Cache Implementation -> node should become the new head
			update(node);
			return;
		} else {
			// data not cached previously
			Node node = new Node(id, data);

			// cache the new node and set it as head if < 5 capacity
			if (this.size < Constant.CAPACITY) {
				this.size++;
				add(node);
			} else {
				// cache full = remove tail and then add a new node
				removeTail();
				add(node);
			}
		}
	}

	// add node and set it as head
	private void add(Node newNode) {

		// set the new node's nextNode as current head.
		newNode.setNextNode(this.cacheLinkedList.getHeadNode());
		// new node's previousNode should be null as it'll be the new head
		newNode.setPreviousNode(null);

		// old head if not null should, it's previous node should point to the new node
		if (cacheLinkedList.getHeadNode() != null)
			cacheLinkedList.getHeadNode().setPreviousNode(newNode);

		// set new node as head node
		cacheLinkedList.setHeadNode(newNode);

		// head=tail=newNode if only one node in the list
		if (cacheLinkedList.getTailNode() == null)
			cacheLinkedList.setTailNode(newNode);

		// store the newNode is the map
		this.nodeMap.put(newNode.getId(), newNode);
	}

	// remove last item (least frequently used)
	private void removeTail() {

		// get node from the map
		Node lastNode = this.nodeMap.get(this.cacheLinkedList.getTailNode().getId());

		// last node's previousNode is new tail node
		this.cacheLinkedList.setTailNode(cacheLinkedList.getTailNode().getPreviousNode());

		// tailNode's nextNode should be null
		if (this.cacheLinkedList.getTailNode() != null)
			this.cacheLinkedList.getTailNode().setNextNode(null);

		// avoid obsolete references
		lastNode = null;
	}

	// most used item should be brought to the front of the list
	public Node get(int id) {

		// the map does not contain the item [O(1) running time!!!]
		if (!this.nodeMap.containsKey(id))
			return null;

		// the map contains the item
		Node requestedNode = this.nodeMap.get(id);
		// move requestedNode to the head 
		update(requestedNode);
		return requestedNode;
	}

	// move the given node to the front (head)
	private void update(Node node) {

		// store the previous node and the next node
		Node previousNode = node.getPreviousNode();
		Node nextNode = node.getNextNode();

		// middle node in the list
		if (previousNode != null)
			previousNode.setNextNode(nextNode);
		else 
			this.cacheLinkedList.setHeadNode(nextNode);

		// not the last node
		if (nextNode != null)
			nextNode.setPreviousNode(previousNode);
		else 
			this.cacheLinkedList.setTailNode(previousNode);

		// move the node to the front
		add(node);
	}

	public void show() {

		Node node = this.cacheLinkedList.getHeadNode();

		while (node != null) {
			System.out.print(node + "<->");
			node = node.getNextNode();
		}
	}
}