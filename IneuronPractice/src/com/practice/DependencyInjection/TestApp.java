package com.practice.DependencyInjection;

import com.practice.bean.*;

public class TestApp {

	public static void main(String[] args) {
		
		//Constructor injection(One-One mapping example)
		//Dependent object
		BankAccount account= new BankAccount("Jai", "Axis", "Savings");
        //Target object
		Employee employee= new Employee("jai",5,"ASE1",account);
		employee.printEmployeeOneToOne();

		
		
		//Setter & Getter Injection(one-Many injection example)
		//Dependent object
		Employee[] employees = new Employee[2];
		employees[0] = employee;
		//Target object
		Department dept = new Department();
		dept.setdName("Autonmous Accounting");
		dept.setdCount(2);
		dept.setEmployee(employees);
		dept.printDeptOneToMany();
		
		
		
		//Many-One Injection(multiple students joining in same branch)
		Branch branch= new Branch();
		branch.setBranchId(1);
		branch.setBranchName("DLF branch");
		branch.setBranchLocation("Hyderabad");
		
		// Here many Student objects are using same branch (M-1)
		Student std1 = new Student();
		std1.setId(1);
		std1.setName("Jai");
		std1.setAddress("STVD");
		std1.setBranch(branch);
		
		Student std2 = new Student();
		std2.setId(2);
		std2.setName("dhanush");
		std2.setAddress("PTR");
		std2.setBranch(branch);
		
		Student std3 = new Student();
		std3.setId(3);
		std3.setName("sai");
		std3.setAddress("TPT");
		std3.setBranch(branch);
	}

}
