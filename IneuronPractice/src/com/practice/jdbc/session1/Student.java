package com.practice.jdbc.session1;

public class Student {

	private Long rollNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long age;
	private String city;
	
	public Student(Long rollNumber,String firstName,String middleName,String lastName,Long age,String  city) {
		this.rollNumber = rollNumber;
		this.firstName  = firstName;
		this.middleName = middleName;
		this.lastName   = lastName;
		this.age        = age;
		this.city       = city;
	}
	
	public Long getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Long rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
//roll_number,first_name,middle_name,last_name,age,city