package com.practice.bean;

public class Employee {
	
	private String empName;
	private Integer empId;
	private String empRole;
	
	//one-one mapping (Has-A relationship)
	private Account account;
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Employee(String empName, Integer empId, String empRole, Account account) {
		this.empName= empName;
		this.empId= empId;
		this.empRole= empRole;
		this.account= account;
	}
	
	public void printEmployeeOneToOne() {
		System.out.println("Employee details");
		System.out.println("Employee id    :: "+empId);
		System.out.println("Employee name  :: "+empName);
		System.out.println("Employee Role  :: "+empRole);
		System.out.println("================================");
		System.out.println("Employee Account Details ");
		System.out.println("Accountant Name :: "+account.accName);
		System.out.println("Bank Name       :: "+account.bankName);
		System.out.println("Accountant type :: "+account.accType);
		
	}

}
