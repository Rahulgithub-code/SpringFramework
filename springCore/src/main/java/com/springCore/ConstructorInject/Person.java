package com.springCore.ConstructorInject;

public class Person {

	private int personId;
	private String personName;
	private Certi cert;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String personName, Certi cert) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.cert = cert;
	}

	@Override
	public String toString() {
		return this.personId + " " +this.personName + "{"+this.cert.name+"}" ;
		
	}
}
