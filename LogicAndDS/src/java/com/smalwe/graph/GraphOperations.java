package com.smalwe.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphOperations {
	
	
	public static void main(String args[]){
		GraphNode<Integer> n = createGraph();
		breadthFS(n);
	}
	
	public static GraphNode<Integer> createGraph(){
		GraphNode<Integer> n1 = new GraphNode<Integer>(1);
		GraphNode<Integer> n2 = new GraphNode<Integer>(2);
		GraphNode<Integer> n3 = new GraphNode<Integer>(3);
		GraphNode<Integer> n4 = new GraphNode<Integer>(4);
		GraphNode<Integer> n5 = new GraphNode<Integer>(5);
		
		List<GraphNode<Integer>> l1 = new ArrayList<GraphNode<Integer>>();
		List<GraphNode<Integer>> l2 = new ArrayList<GraphNode<Integer>>();
		List<GraphNode<Integer>> l3 = new ArrayList<GraphNode<Integer>>();
		List<GraphNode<Integer>> l4 = new ArrayList<GraphNode<Integer>>();
		List<GraphNode<Integer>> l5 = new ArrayList<GraphNode<Integer>>();
		
		l1.add(n2);
		l1.add(n5);
		
		l2.add(n1);
		l2.add(n3);
		l2.add(n5);
		
		l3.add(n2);
		l3.add(n4);
		
		l4.add(n3);
		l4.add(n5);
		
		l5.add(n1);
		l5.add(n2);
		l5.add(n3);
		
		n1.setaN(l1);
		n2.setaN(l2);
		n3.setaN(l3);
		n4.setaN(l4);
		n5.setaN(l5);
		
		return n1;
	}
	
	public static void breadthFS(GraphNode<Integer> n){
		if(n == null){
			return;
		}
		Queue<GraphNode<Integer>> q = new LinkedList<GraphNode<Integer>>();
		q.add(n);
		
		GraphNode<Integer> temp;
		//white = 0; grey = 1; black =2
		while(!q.isEmpty()){
			temp = q.poll();
			temp.setColor(2);
			System.out.println(temp.getVal());
			//System.out.println("Size of temp:" + temp.getaN().size());
			for(int i=0; i<temp.getaN().size(); i++){
				GraphNode<Integer> temp2;
				temp2 = temp.getaN().get(i);
				//System.out.println("Came in for");
				if(temp2.getColor() <1){
					//System.out.println("Came in if");
					temp2.setColor(1);
					q.add(temp2);
				}
			}
		}
		
		
	}
}
