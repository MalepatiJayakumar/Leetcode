package com.practice.dto;

public class EmployeeDTO {

	private Long id;

	private String name;
	
	private String organization;
	
	private String location;

	private Double salary;
	
	public EmployeeDTO(Long id, String name, String organization, String location, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.location = location;
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
		return "EmployeeDTO [id=" + id + ", name=" + name + ", organization=" + organization + ", location=" + location
				+ ", salary=" + salary + "]";
	}
}