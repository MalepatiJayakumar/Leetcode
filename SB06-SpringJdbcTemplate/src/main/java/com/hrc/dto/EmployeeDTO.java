package com.hrc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmployeeDTO{
	
	private Long id;
	private String name;
	private Integer age;
	private String address;
	private Double salary;
	
	public EmployeeDTO(String name, Integer age, String address, Double salary) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", salary="
				+ salary + "]";
	}
}