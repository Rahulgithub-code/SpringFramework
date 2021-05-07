package com.springCore.JavaConfigWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {
	public static void main(String[] args) {
		
		//for handle Annotation configure we use AnnotationConfigApplicationContext()
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student s1= context.getBean("student", Student.class);
		System.out.println(s1);
		System.out.println(s1.Reading());
	}
}
