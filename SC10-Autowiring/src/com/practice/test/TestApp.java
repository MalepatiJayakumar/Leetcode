package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.controller.Amazon;

public class TestApp {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		Amazon amazon = factory.getBean("amazon",Amazon.class);
		System.out.println(amazon);
		
		Amazon amazon1 = factory.getBean("amz1",Amazon.class);
		System.out.println(amazon1);
	}
}