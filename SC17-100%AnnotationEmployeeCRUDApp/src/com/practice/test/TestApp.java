package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.practice.configuration.AppConfig;
import com.practice.controller.EmployeeController;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeController controller = context.getBean(EmployeeController.class);
		controller.saveEmployee();
		
		((AbstractApplicationContext) context).close();
	}
}