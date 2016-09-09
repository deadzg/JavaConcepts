package com.smalwe.jmx;

public class Test implements TestMBean{

	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
