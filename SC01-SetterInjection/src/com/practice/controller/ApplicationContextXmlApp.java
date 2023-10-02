package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.service.DateOperationsService;

public class ApplicationContextXmlApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Before reading bean factory");
		System.out.println();
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		System.out.println("\nAfter creating an bean factory");
		System.out.println();
		DateOperationsService dops = factory.getBean("dops",DateOperationsService.class);
		System.out.println();
		System.out.println("Post fetching object for desired class");
	}
}