package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		EngineeringCourses courses = factory.getBean("secondYear",EngineeringCourses.class);
		System.out.println("Courses :: "+courses);
	}
}	