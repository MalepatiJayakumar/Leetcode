package com.practice.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.practice.service.EmployeeService;

public class XmlBeanFactoryConstructorInjection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/Beans.xml"));
		EmployeeService emp = factory.getBean("emps",EmployeeService.class);
		
		/* How spring creates an bean in Backend for constructor injection */
//		Class cls = Class.forName("com.practice.service.EmployeeService");
//		Constructor[] constructors = cls.getDeclaredConstructors();
//		EmployeeService emp1 = (EmployeeService) constructors[0].newInstance(new Date());
	}
}