package com.springCore.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionDemo {
	public static void main(String[] args) {
		System.out.println("Starting . . .");
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/Collection/collectionConfig.xml");
		Emp emp1 = (Emp) context.getBean("emp1");
		System.out.println(emp1.getName());
		System.out.println(emp1.getAddress());
		System.out.println(emp1.getPhone());
		System.out.println(emp1.getCourse());
		System.out.println(emp1.getProps());
		System.out.println(emp1.getPhone().getClass().getName());
		
	}
}
