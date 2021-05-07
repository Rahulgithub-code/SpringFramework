package com.springCore.stereoType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("com/springCore/stereoType/stereoConfig.xml");
		Student student= context.getBean("student", Student.class);
		System.out.println(student);
		System.out.println("----------------------");
		System.out.println(student.getPhones());
		System.out.println(student.getPhones().getClass().getName());
		System.out.println("----------------------");
		System.out.println("Prototype Scope using annotation");
		Student student1= context.getBean("student", Student.class);
		System.out.println(student.hashCode());
		System.out.println(student1.hashCode());
		System.out.println("----------------------");
		System.out.println("Prototype Scope using XML");
		Teacher teacher1= context.getBean("teacher1",Teacher.class);
		Teacher teacher2= context.getBean("teacher1",Teacher.class);
		System.out.println(teacher1.hashCode());
		System.out.println(teacher2.hashCode());
	}

}
