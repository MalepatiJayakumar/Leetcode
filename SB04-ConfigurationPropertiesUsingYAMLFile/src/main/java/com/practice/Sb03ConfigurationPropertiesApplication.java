package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.DTO.Employee;

@SpringBootApplication
public class Sb03ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sb03ConfigurationPropertiesApplication.class, args);
		Employee emp1 =  context.getBean(Employee.class);
		System.out.println(emp1);
	}
}