package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.DTO.Employee;
import com.practice.DTO.Hotel;

@SpringBootApplication
public class Sb03ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sb03ConfigurationPropertiesApplication.class, args);
		Employee emp = context.getBean(Employee.class);
		System.out.println(emp);
		
		// Getting the employee hotel expenses
		
		Hotel hotel = context.getBean(Hotel.class);
		System.out.println(hotel);
	}
}