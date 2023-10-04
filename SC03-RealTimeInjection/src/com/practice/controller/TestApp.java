package com.practice.controller;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.practice.service.Flipkart;

public class TestApp {
	
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(factory);
		xmlReader.loadBeanDefinitions("Beans.xml");
		
		Flipkart flipkart = factory.getBean("flipkart",Flipkart.class);
		String msg = flipkart.doShopping(new String[] {"Biscuits","Chacolates"},new Float[] {20.0f,34.9f});
		System.out.println(msg);
	}
}