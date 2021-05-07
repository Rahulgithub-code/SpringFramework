package com.springCore.LifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImplementLifeCycleWithXMLFile {

	public static void main(String[] args) {
		//ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/LifeCycle/Config.xml");
		
		//enable pre-shutdown hook
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/LifeCycle/Config.xml");
		Samosa s1 =  (Samosa) context.getBean("s2");
		System.out.println(s1);
		
		//Registering shutdown hook
		context.registerShutdownHook();
	}
}
