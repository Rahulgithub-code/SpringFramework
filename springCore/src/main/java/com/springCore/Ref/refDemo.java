package com.springCore.Ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class refDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springCore/Ref/refConfig.xml");
		//A arefA = (A) context.getBean("aRef");
		//System.out.println(arefA.getX());
		//System.out.println(arefA.getOb().getY());
		
		A aref1 = (A) context.getBean("aRef2");
		System.out.println(aref1.getX());
		System.out.println(aref1.getOb().getY());
	}

}
