package com.smalwe.generics;

public class LinkedList {
	public static void main(String args[]){
		/*Node<String> n1 = new Node<String>();
		n1.setValue("Val1");
		Node<String> n2 = new Node<String>();
		n2.setValue("Val2");
		Node<String> n3 = new Node<String>();
		n3.setValue("Val3");
		Node<String> n4 = new Node<String>();
		n4.setValue("Val4");
		Node<String> curr = n1;*/
		
		/*Node<Integer> n1 = new Node<Integer>();
		n1.setValue(1);
		Node<Integer> n2 = new Node<Integer>();
		n2.setValue(2);
		Node<Integer> n3 = new Node<Integer>();
		n3.setValue(3);
		Node<Integer> n4 = new Node<Integer>();
		n4.setValue(4);
		Node<Integer> curr = n1;*/
		
		
		Node<Integer> n1 = new Node<Integer>(1);
		
		Node<Integer> n2 = new Node<Integer>(2);
		
		Node<Integer> n3 = new Node<Integer>(3);
		
		Node<Integer> n4 = new Node<Integer>(4);
		
		Node<Integer> curr = n1;
		
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		
		
		
		while(curr != null){
			System.out.println(curr.getValue());
			curr = curr.getNextNode();
		}
		
	}
}
