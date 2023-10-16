package com.practice.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practice.dto.EmployeeDTO;
import com.practice.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public void saveEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter employee name :: ");
		String name = scan.next();
		
		System.out.println("Enter employee working organization name :: ");
		String organization = scan.next();
		
		System.out.println("Enter employee working location :: ");
		String location = scan.next();
		
		System.out.println("Enter employee current salary :: ");
		Double salary = scan.nextDouble();
		
		EmployeeDTO emp = new EmployeeDTO(null,name,organization,location,salary);
	
		System.out.println(employeeService.saveEmployee(emp));
		
		scan.close();
	}
	
}