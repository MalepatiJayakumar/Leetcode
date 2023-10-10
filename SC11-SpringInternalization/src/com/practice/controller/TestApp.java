package com.practice.controller;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Locale locale = new Locale("hi", "IN");
		System.out.println(context.getMessage("btn1.cap", null, locale));
		System.out.println(context.getMessage("btn2.cap", null, locale));
		System.out.println(context.getMessage("btn3.cap", null, locale));
		System.out.println(context.getMessage("btn4.cap", null, locale));
	}
}