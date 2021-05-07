package com.springCore.LifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImplementLifeCycleWithBeanInterface {

	public static void main(String[] args) {
		

		//enable pre-shutdown hook we use AbstractApplicationContext
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springCore/LifeCycle/Config.xml");
		// Registering shutdown hook
		context.registerShutdownHook();
		Pepsi p1 = (Pepsi) context.getBean("p1");
		System.out.println(p1);
	}

}
