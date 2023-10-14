package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.practice.configuration.AppConfiguration;
import com.practice.execution.WishMessageGenerator;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		WishMessageGenerator wmg = context.getBean(WishMessageGenerator.class);
		System.out.println(wmg.generateWishMessage("jaykumar"));
		((AbstractApplicationContext) context).close();
	}
}