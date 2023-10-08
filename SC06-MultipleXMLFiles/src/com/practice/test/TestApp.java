package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.controller.EmployeeController;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeController controller = factory.getBean("controller",EmployeeController.class);
	}
}