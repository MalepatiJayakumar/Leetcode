package com.practice.constructorInheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		
		Student std1 = factory.getBean("std1",Student.class);
		System.out.println("Student 1 :: "+std1);
		Student std2 = factory.getBean("std2",Student.class);
		System.out.println("Student 2 :: "+std2);
	}
}
/**
Student 1 :: Student [id=1, name=JayKumar Reddy, age=22, collge=Chandigarh University, location=Chandigarh, dept=Computer Science and Engineering, universityRank=1]
Student 2 :: Student [id=2, name=Tharun, age=23, collge=Chandigarh University, location=Chandigarh, dept=Computer Science and Engineering, universityRank=1]
*/