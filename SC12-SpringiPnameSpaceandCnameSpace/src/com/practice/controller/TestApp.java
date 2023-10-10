package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.bean.Employee;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Employee employee = context.getBean("employee",Employee.class);
		System.out.println(employee);
	}
}