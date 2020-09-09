package com.learning.restservices.Hello;

public class UserDetails {
	
	private String FName;
	private String LName;
	private Integer Age;
	
	
	
	public UserDetails(String fName, String lName, Integer age) {
		FName = fName;
		LName = lName;
		Age = age;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	
	@Override
	public String toString() {
		return "UserDetails [FName=" + FName + ", LName=" + LName + ", Age=" + Age + "]";
	}
	
	
	

}
