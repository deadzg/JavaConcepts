package com.smalwe.generics;

public class GenericMethodTestWithExtendClass {
	public static <K extends Integer, V extends Integer>  boolean match(Pair<K,V> p1, Pair<K,V> p2){
		if(p1.getKey() == p2.getKey() && p1.getValue() == p2.getValue()){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		
		/*This wont work in the match method as we have specified the type arguments to work only with Integer and it's subclasses
		 * Pair<Integer, String> p1 = new Pair<Integer, String>(56, "key1");
		Pair<Integer, String> p2 = new Pair<Integer, String>(56, "key2");*/
		
		
		Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(56, 76);
		Pair<Integer, Integer> p2 = new Pair<Integer, Integer>(56, 76);
		
		System.out.println("Does the pair match?? " +match(p1,p2));
	}
}
