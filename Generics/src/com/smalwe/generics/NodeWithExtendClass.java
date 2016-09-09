package com.smalwe.generics;


/**
 * Node object can be defined  only for those classes which are subclasses
 * of Integer or Integer class
 * @author soumalwe
 * Sep 9, 2016
 * @param <T>
 */
public class NodeWithExtendClass<T extends Integer> {
	
	private T value;
	private NodeWithExtendClass nextNode;
	
	NodeWithExtendClass(T value){
		this.value = value;
	}

	public NodeWithExtendClass getNextNode() {
		return nextNode;
	}

	public void setNextNode(NodeWithExtendClass nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
