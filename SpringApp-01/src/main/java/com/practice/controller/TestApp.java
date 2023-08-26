package com.practice.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.serviceImpl.CreditCardPay;
import com.practice.serviceImpl.DebitCardPay;

public class TestApp {
	public static void main(String[] args) {
		System.out.println("Inside main app");
		/*
		 * Old approach of loading xml and generating beans, from application context
		 * version 6 we are not even going to get deprecated things
		 */
		Resource resource = new ClassPathResource("Beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		factory.getBean("credit",CreditCardPay.class);
		factory.getBean("debit",DebitCardPay.class);
		PaymentProcess pay = factory.getBean("pay",PaymentProcess.class);
		pay.doPayment(1500d);
	}
}