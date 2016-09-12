package com.smalwe.graph;

import java.util.List;

public class GraphNode<T> {
	private T val;
	private int color = 0; //white = 0; grey = 1; black =2
	private List<GraphNode<T>> aN;
	
	GraphNode(T val){
		this.val = val;
	}
	
	public T getVal() {
		return val;
	}
	public void setVal(T val) {
		this.val = val;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public List<GraphNode<T>> getaN() {
		return aN;
	}
	public void setaN(List<GraphNode<T>> aN) {
		this.aN = aN;
	}
	
	
}
