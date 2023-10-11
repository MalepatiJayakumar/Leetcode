package com.practice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.controller.InsurancePolicyController;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		InsurancePolicyController policy = context.getBean(InsurancePolicyController.class);
		System.out.println(policy);
		policy.saveInsurancePolicy();
	}
}