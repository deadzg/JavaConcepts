package com.smalwe.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class JMXDriver {
	public static void main(String args[]) throws MalformedObjectNameException, InterruptedException{
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		Test mBean = new Test();
		mBean.setName("Sourabh");
		
		ObjectName obj = new ObjectName("com.smalwe.jmx:type=Test");
		
		while(true){
			Thread.sleep(5000);
			System.out.println(mBean.getName());
		}
	}
}
