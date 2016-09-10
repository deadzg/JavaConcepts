package com.smalwe.generics;

/**
 * Generic method example
 * @author soumalwe
 * Sep 10, 2016
 */
public class GenericMethodTest {
	
	public static <K,V> boolean  match(Pair<K,V> p1, Pair<K,V> p2){
		if(p1.getKey().equals(p2.getKey()) && 
				p2.getValue().equals(p1.getValue())){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		Pair<String,Integer> p1 = new Pair<String,Integer>("key1", 56);
		Pair<String,Integer> p2 = new Pair<String, Integer>("key1", 56);
		
		System.out.println("Does the pair match?? " + match(p1,p2));
	}
}
