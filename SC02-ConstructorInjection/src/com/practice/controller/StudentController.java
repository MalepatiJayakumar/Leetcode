package com.practice.controller;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.practice.service.Student;

@SuppressWarnings("deprecation")
public class StudentController {
	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/Beans.xml"));
		
		System.out.println("Student :: from setting values based on datatypes of constructor");
		Student std1 = factory.getBean("std1",Student.class);
		System.out.println(std1);
		
		System.out.println("\nStudent :: from setting values based on index of constructor");
		Student std2 = factory.getBean("std2",Student.class);
		System.out.println(std2);
		
		System.out.println("\nStudent :: from setting values based on values of fields in constructor");
		Student std3 = factory.getBean("std3",Student.class);
		System.out.println(std3);
	}
	/* OUTPUT
	 * ======
	 * 	Student :: from setting values based on datatypes of constructor
		Student [id=1, name=jai, college=Chandigarh University, percentage=79.9]

		Student :: from setting values based on index of constructor
		Student [id=2, name=dhanush, college=Apollo University, percentage=85.8]

		Student :: from setting values based on values of fields in constructor
		Student [id=3, name=mahesh, college=Sidhartha Engineering College, percentage=68.8]
	 */
}