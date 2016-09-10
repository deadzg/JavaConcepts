package com.smalwe.generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConcurrentQueueTest {
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testPushWithString(){
		ConcurrentQueue<String> cq = new ConcurrentQueue<String>();
		cq.push("Hello");
		assertEquals("Hello", cq.pop());
	}
	
	@Test
	public void testPushWithInteger(){
		
	}
	
	/*@Test(expected = Exception.class)
	public void testPushWithStringNullException(){
		ConcurrentQueue<String> cq = new ConcurrentQueue<String>();
		cq.pop();
	}*/
	
	@Test
	public void testPushWithStringNull(){
		ConcurrentQueue<String> cq = new ConcurrentQueue<String>();
		assertEquals(null, cq.pop());
	}
	
}
