package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="org_employee")
//@DynamicInsert(value=true) // It won't use inbuilt query , creates an dynamic query post setting the values in an object
public class Employee {
	
	@Id
	@Column(name="pk_id")
	private Long empId;
	
	@Column(name="name")
	private String empName;
	
	@Column(name="organization")
	private String empOrganization;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="location")
	private String location;

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

	public String getEmpOrganization() {
		return empOrganization;
	}

	public void setEmpOrganization(String empOrganization) {
		this.empOrganization = empOrganization;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Employee(){
		System.out.println("Zero argument constructor in Employee object");
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empOrganization=" + empOrganization
				+ ", salary=" + salary + ", location=" + location + "]";
	}
	
}
