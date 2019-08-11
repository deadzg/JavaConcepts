package com.smalwe.streams;

import java.io.Serializable;

public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String color;
	String make;
	int seats;
	transient boolean isSuv;
	
	
	public Car(String color, String make, int seats, boolean isSuv) {
		this.color = color;
		this.make = make;
		this.seats = seats;
		this.isSuv = isSuv;
	}
	
	public String toString() {
		return "Car color:" + color;
	}
	
}
