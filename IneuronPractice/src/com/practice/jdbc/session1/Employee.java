package com.practice.jdbc.session1;

public class Employee {
	
	private String name;
	private Integer age;
	private String address;
	private Double salary;
	
	public Employee(String name,Integer age,String address,Double salary) {
		this.name = name;
		this.age  = age;
		this.address = address;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
