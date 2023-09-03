package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="org_employee")
public class Employee {

	@Id
	@GenericGenerator(name="gen1",strategy="com.practice.generators.CustomGenerator")
	@GeneratedValue(generator="gen1")
	@Column(name="pk_id")
	private String id;
	
//	@Column(name="name")
	private String name;
	
//	@Column(name="organization")
	private String organization;
	
//	@Column(name="location")
	private String location;

//	@Column(name="salary")
	private Double salary;

	public Employee() {
		System.out.println("Employee zero argument contructor");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "Employee [id=" + id + ", name=" + name + ", organization=" + organization + ", location=" + location
				+ ", salary=" + salary + "]";
	}
}
