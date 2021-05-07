package com.springCore.stereoType;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//@Component("ob") rename student object
public class Student {
	@Value("Rahul")
	private String sudentName;

	@Value("Ranchi")
	private String city;
	
	@Value("#{temp}") //Spring expression language (SpEL)
	private List<String> phones; 

	public String getSudentName() {
		return sudentName;
	}

	public void setSudentName(String sudentName) {
		this.sudentName = sudentName;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [sudentName=" + sudentName + ", city=" + city + ", phones=" + phones + "]";
	}
}
