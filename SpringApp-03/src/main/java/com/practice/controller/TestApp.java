package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		
		/* Reading beans properties using spring xml application context */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		SelectCourse course = context.getBean("select",SelectCourse.class);
		course.selectCourse();
	}
}