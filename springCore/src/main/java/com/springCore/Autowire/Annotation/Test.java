package com.springCore.Autowire.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/Autowire/Annotation/autowireConfig.xml");
		
		//auto typecast using Emp.class
		Emp emp1 = context.getBean("emp1", Emp.class);
		System.out.println(emp1);
	}

}
