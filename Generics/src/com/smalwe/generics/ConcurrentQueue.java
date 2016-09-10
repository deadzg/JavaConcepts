package com.smalwe.generics;

import java.util.ArrayList;

public class ConcurrentQueue<T> {
	
	private Node<T> head;
	private T value;
	
	
	public synchronized void  push(T value){
		
		Node<T> newNode = new Node<T>(value);
		Node<T> currentNode = head;
		if(currentNode == null){
			head = newNode;
			return;
		}
		while(currentNode.getNextNode() !=null){
			currentNode = currentNode.getNextNode();
		}
		currentNode.setNextNode(newNode);
		
	}
	
	public synchronized T pop(){
		Node<T> node = head;
		if(head == null){
			return null;
		}
		if(head != null){
			head = head.getNextNode();
		}
		return node.getValue();
	}
	
	public synchronized ArrayList<T> peek(){
		Node<T> currentNode = head;
		ArrayList<T> ar = new ArrayList<T>();
		while(currentNode != null){
			ar.add(currentNode.getValue());
			currentNode = currentNode.getNextNode();
		}
		return ar;
	}
}
