package com.learn.dsa.binarysearchtree;

public class BinarySearchTreeApp {
	
	public static void main(String[] args) {
		
		Tree<Person> bst = new BinarySearchTree<Person>();
		
		bst.insert(new Person("aakash",12));
		bst.insert(new Person("bakka",20));
		bst.insert(new Person("zowzmx",22));
		bst.insert(new Person("weqwe",46));
		bst.insert(new Person("dbsass",2));
		
		bst.traverse();
		
		/*Tree<String> bst = new BinarySearchTree<String>();
		
		bst.insert(-111);
		bst.insert(10);
		bst.insert(-1);
		bst.insert(0);
		bst.insert(1000);
		bst.insert(-22);
		
		bst.insert("An");
		bst.insert("Xw");
		bst.insert("Os");
		bst.insert("Zx");
		bst.insert("Hs");
		bst.insert("Wa");
		
		System.out.println(bst.getMax());
		System.out.println(bst.getMin());
		
		bst.traverse();
		
		bst.delete("An");
		
		bst.traverse();*/
	}

}
