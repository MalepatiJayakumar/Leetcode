package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.controller.EmployeeController;

@SpringBootApplication
public class Sb02HikariCpProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sb02HikariCpProjectApplication.class, args);
		System.out.println("Implementation class :: "+context.getClass().getName());
	
		EmployeeController controller = context.getBean(EmployeeController.class);
		controller.saveEmployee();
		
	}
}