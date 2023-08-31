package com.practice.dto;

public class Employee {
	
	private Long empId;
	
	private String empName;
	
	private Integer age;
	
	private String address;
	
	private Double salary;
	
	public Employee() {
		
	}
	
	public Employee(String empName , Integer age , String address) {
		this.empName = empName;
		this.age = age;
		this.address = address;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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
