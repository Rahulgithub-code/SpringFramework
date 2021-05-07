package com.springCore.Autowire.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
	@Autowired
	@Qualifier("add2") //this used for specifying name of bean's, if we 2 or more bean's 
	private Address address;

	public Address getAddress() {
		return address;
	}

	//@Autowired
	public void setAddress(Address address) {
		this.address = address;
		System.out.println("I'm setAddress()");
	}

	//@Autowired
	public Emp(Address address) {
		super();
		this.address = address;
		System.out.println("I'm field constructor");
	}

	public Emp() {
		super();
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	
	

}
