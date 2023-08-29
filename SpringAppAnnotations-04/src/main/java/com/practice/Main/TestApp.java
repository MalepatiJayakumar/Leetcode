package com.practice.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.configurations.UserConfiguration;

public class TestApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		UserConfiguration config = context.getBean(UserConfiguration.class);
		config.getInstance();
		
	}

}
