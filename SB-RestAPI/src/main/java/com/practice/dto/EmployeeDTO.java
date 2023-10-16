package com.practice.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("employee")
public class EmployeeDTO {

	private String name;
	
	private String organization;
	
	private String location;
	
	private Double salary;

	public EmployeeDTO(String name, String organization, String location, Double salary) {
		this.name = name;
		this.organization = organization;
		this.location = location;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", organization=" + organization + ", location=" + location + ", salary="
				+ salary + "]";
	}
	
}