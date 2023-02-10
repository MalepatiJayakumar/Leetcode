package com.practice.bean;

public class Department {
	
	private String dName;
	private Integer dCount;
	
	Employee[] employee;

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Integer getdCount() {
		return dCount;
	}

	public void setdCount(Integer dCount) {
		this.dCount = dCount;
	}

	public Employee[] getEmployee() {
		return employee;
	}

	public void setEmployee(Employee[] employee) {
		this.employee = employee;
	}
	
	public void printDeptOneToMany() {
		System.out.println("================================");
		System.out.println("Inside Department --> printDeptOneToMany method");
		System.out.println("Department Name  :: "+dName);
		System.out.println("Department Count :: "+dCount);
		System.out.println("Employee Count    :: "+employee.length);
	}
	
//	public Department(String dName, Integer dCount, Employee[] employee) {
//		this.dName= dName;
//		this.dCount= dCount;
//		this.employee= employee;
//	}
	

}
