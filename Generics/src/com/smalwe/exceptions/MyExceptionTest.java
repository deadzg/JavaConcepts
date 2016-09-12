package com.smalwe.exceptions;

public class MyExceptionTest {

	public static void main(String agrs[]){
		int age = 15;
		try{
			validate(age);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	
	public static void validate (int age) throws MyException{
		if(age <18){
			throw new MyException("Invalid Age");
		}
		else{
			System.out.println("Welcome for vote");
		}
	}
}
