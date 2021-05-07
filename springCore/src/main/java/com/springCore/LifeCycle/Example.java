package com.springCore.LifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	private String example;

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Example [example=" + example + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("init with annotation");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy with annotation");
	}
}
