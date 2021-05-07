package com.springCore.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springCore/SpEL/config.xml");
		Demo d1 = context.getBean("demo", Demo.class);
		System.out.println(d1);
		
		
		//SpEL with SpelExpressionParser()
		SpelExpressionParser exp1 = new SpelExpressionParser();
		Expression expression=  exp1.parseExpression("20+11");
		System.out.println(expression.getValue());
	}
}
