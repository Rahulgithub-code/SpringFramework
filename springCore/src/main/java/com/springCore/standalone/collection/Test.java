package com.springCore.standalone.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/standalone/collection/standAloneConfig.xml");
		 Person p1= context.getBean("person1", Person.class);
		 System.out.println(p1);
		 System.out.println("++++++++++++++++++++++");
		 System.out.println(p1.getFeeStructure());
		 System.out.println(p1.getFriends().getClass().getName());
		 System.out.println(p1.getFeeStructure().getClass().getName());
		 
	}

}
