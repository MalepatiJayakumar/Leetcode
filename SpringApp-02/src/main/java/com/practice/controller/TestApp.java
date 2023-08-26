package com.practice.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.DTO.UserDTO;
import com.practice.serviceImpl.EmployeeServiceImpl;
import com.practice.serviceImpl.StudentServiceImpl;


public class TestApp {
	public static void main(String[] args) {
		/* 
		 * Old approach to get bean factory through file reading , But these is deprecated
		 */
//		Resource resource = new ClassPathResource("beans.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		factory.getBean("employee",EmployeeServiceImpl.class);
//		factory.getBean("student",StudentServiceImpl.class);
//		AddUsers addUser = factory.getBean("addUser",AddUsers.class);
		
		/*
		 * New approach to get bean factory through file reading
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.getBean("employee", EmployeeServiceImpl.class);
		context.getBean("student", StudentServiceImpl.class);

		AddUsers addUser = context.getBean("addUser", AddUsers.class);
		UserDTO user = new UserDTO();
		user.setAge(10);
		addUser.addEmployee(user);
		
	}
}
