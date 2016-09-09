package com.smalwe.generics;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
 * This class follows Generics which are not bounded
 * It works for any type of class type.
 * Note: It won't work for primitive data types
 * @author soumalwe
 * Sep 9, 2016
 * @param <T>
 */
public  class Node<T> {
	private T value;
	private Node<T> nextNode;
	
	Node(T value){
		this.value =value;
	}
	
	public T getValue(){
		return value;
	}
	
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
		
	}

	public Node getNextNode() {
		
		return nextNode;
	}
}
