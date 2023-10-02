package com.practice.controller;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.practice.service.DateOperationsService;

public class XmlBeanFactoryApp {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		FileSystemResource resource = new FileSystemResource("src/Beans.xml");
		
		System.out.println("Before reading bean factory");
		System.out.println();
		XmlBeanFactory  factory = new XmlBeanFactory(resource);
		System.out.println("After creating an bean factory");
		System.out.println();
		DateOperationsService dops = factory.getBean("dops",DateOperationsService.class);
		System.out.println();
		System.out.println("Post fetching object for desired class");
		
		/* How spring creates an Beans in Backend */
		System.out.println();
		DateOperationsService dops1 = (DateOperationsService) Class.forName("com.practice.service.DateOperationsService").newInstance();
		
	}
}