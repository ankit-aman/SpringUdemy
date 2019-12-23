package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private Map<String,String> newMap=new LinkedHashMap<>();
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Student() {
	
		newMap.put("IND", "India");
		newMap.put("USA", "UnitedStates");
	
	}
	
	public Map<String, String> getNewMap() {
		return newMap;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
