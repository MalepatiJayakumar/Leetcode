package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * As we are using prototype scope , IOC container won't save any information in
 * internal cache so when ever we need an object it creates an new object
 * 
 * @author malep
 */
public class TestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		UserManager manager = factory.getBean("userManager", UserManager.class);
		System.out.println(manager);
		System.out.println(
				"Hashcode >> User manager ::  " + manager.hashCode() + " >> User :: " + manager.getUser().hashCode());

		UserManager manager1 = factory.getBean("userManager", UserManager.class);
		System.out.println(manager1);
		System.out.println(
				"Hashcode >> User manager ::  " + manager1.hashCode() + " >> User :: " + manager1.getUser().hashCode());
	}
}

/**
 * 	UserManager [user=User [userId=1, username=jaikumar, age=22]]
	Hashcode >> User manager ::  1990451863 >> User :: 1295083508
	UserManager [user=User [userId=1, username=jaikumar, age=22]]
	Hashcode >> User manager ::  249155636 >> User :: 1629604310
 */