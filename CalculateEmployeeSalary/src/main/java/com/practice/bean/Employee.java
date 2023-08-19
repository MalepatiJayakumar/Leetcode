package com.practice.bean;

public class Employee {
	
	private Long empId;
	private String empName;
	private Double empBasicSalary;
	private Double empGrossSalary;
	private Double empNetSalary;
	
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
	public Double getEmpBasicSalary() {
		return empBasicSalary;
	}
	public void setEmpBasicSalary(Double empBasicSalary) {
		this.empBasicSalary = empBasicSalary;
	}
	public Double getEmpGrossSalary() {
		return empGrossSalary;
	}
	public void setEmpGrossSalary(Double empGrossSalary) {
		this.empGrossSalary = empGrossSalary;
	}
	public Double getEmpNetSalary() {
		return empNetSalary;
	}
	public void setEmpNetSalary(Double empNetSalary) {
		this.empNetSalary = empNetSalary;
	}	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empBasicSalary=" + empBasicSalary
				+ ", empGrossSalary=" + empGrossSalary + ", empNetSalary=" + empNetSalary + "]";
	}
}
