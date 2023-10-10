package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.ecommerce.Amazon;
import com.practice.ecommerce.Amazon1;
import com.practice.ecommerce.Amazon2;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		/* Setting an dependent object through field Autowiring*/
		Amazon amz = context.getBean("amz",Amazon.class);
		System.out.println(amz);
		
		/* Setting an dependent object on setter method */
		Amazon1 amz1 = context.getBean("amz1",Amazon1.class);
		System.out.println(amz1);
		
		/* Setting an dependent object using constructor injection using Autowired annotation */
		Amazon2 amz2 = context.getBean(Amazon2.class);
		System.out.println(amz2);
		
	}
}