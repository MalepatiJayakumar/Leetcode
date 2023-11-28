package com.highradius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import comhighradius.service.EmployeeService;
import comhighradius.service.IEmployeeService;

@SpringBootApplication
public class Sb12SpringAspectJApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb12SpringAspectJApplication.class, args);
		
		IEmployeeService employee = new EmployeeService();
		employee.getEmployee();
	}
}