package com.smalwe.generics;

/**
 * Generic pair example
 * @author soumalwe
 * Sep 10, 2016
 * @param <K>
 * @param <V>
 */
public class Pair<K,V> {
	
	private K key;
	private V value;
	
	public Pair(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public void setKey(K key){
		this.key = key;
	}

	public void setValue(V value){
		this.value = value;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
}
