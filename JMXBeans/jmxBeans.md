JMX:
http://www.journaldev.com/1352/what-is-jmx-mbean-jconsole-tutorial
https://en.wikipedia.org/wiki/Java_Management_Extensions
Unleashing Jconsole: http://www.oracle.com/technetwork/articles/java/jconsole-1564139.html

Java Managed Extentions : It's a java technology that supplies tools for managing and monitoring applications, system objects, devices (such as printers) and service-oriented networks.
Thes resources are represented by objects called MBeans (Managed Beans).

Architecture:
It's a three level architecture:
1. The Probe Level : contains Mbeans instrumenting the resources
2. The Agent Level : MBeanServer , it acts as intermediary between the MBean and applications
3. The Remote Management Level : Enables remote applications to access the MBeanServer through connectors and adaptors.
	Note: Connectors provide full remote access to the MBeanServer API using various communication (RMI, JMS,..)
	      Adaptors adapts the API to another protocol (SNMP,...) or Web-based GUI (HTML/HTTP, WML/HTTP)

JConsole can be used to connect to local/remote MBeanServer and manage registered resources



