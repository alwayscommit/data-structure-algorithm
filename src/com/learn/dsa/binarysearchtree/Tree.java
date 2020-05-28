package com.learn.dsa.binarysearchtree;

public interface Tree<T> {

	public Node<T> getKSmallest(Node<T> node, int k);
	public Node<T> getRoot();
	public void traverse();
	public void insert(T data);
	public void delete(T data);
	public T getMax();
	public T getMin();
	
}
