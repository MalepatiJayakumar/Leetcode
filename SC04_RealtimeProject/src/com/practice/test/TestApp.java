package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.controller.MainController;

public class TestApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * As we are using application.properties files to read DB properties.
		 * DefaultListableBeanFactory container won't support for properties file so we
		 * need to use ApplicationContext
		 */
	/*	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("Beans.xml"); 
	*/
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		
		MainController controller = factory.getBean("controller",MainController.class);
	}
}