package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextConstructorInjection {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
	}
}