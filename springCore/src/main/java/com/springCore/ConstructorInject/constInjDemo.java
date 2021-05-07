package com.springCore.ConstructorInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class constInjDemo {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/ConstructorInject/constructorInjConfig.xml");
		Person person = (Person) context.getBean("person1");
		System.out.println(person);
	}

}
