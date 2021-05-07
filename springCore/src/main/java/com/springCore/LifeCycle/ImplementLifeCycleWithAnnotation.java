package com.springCore.LifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImplementLifeCycleWithAnnotation {

	public static void main(String[] args) {

		/*
		 * @PostConstruct and @PreDestroy annotations are part of Java EE. And since
		 * Java EE has been deprecated in Java 9 and removed in Java 11 we have to add
		 * an additional dependency to use these annotations:
		 */

		// enable pre-shutdown hook we use AbstractApplicationContext
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springCore/LifeCycle/Config.xml");
		// Registering shutdown hook
		context.registerShutdownHook();
		Example e1 = (Example) context.getBean("e1");
		System.out.println(e1);
	}

}
