package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configure.xml");
		Voter voter = context.getBean(Voter.class);
		System.out.println(voter);
		System.out.println(voter.checkVoterEligibility());
		((AbstractApplicationContext) context).close();
	}
}