package com.practice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * As we are using Singleton scope , even if we are calling multiple times to
 * get the object we get the same object which is stored in internal cache.
 * 
 * But user object should be seperate for each request but here we will get the
 * same user object only if we use singleton scope. For this only we have
 * prototype scope.
 * 
 * @author malep
 */
public class TestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		UserManager manager = factory.getBean("userManager", UserManager.class);
		System.out.println(manager);
		System.out.println("Hashcode >> User manager ::  " + manager.hashCode()+" >> User :: "+manager.getUser().hashCode());

		UserManager manager1 = factory.getBean("userManager", UserManager.class);
		System.out.println(manager1);
		System.out.println("Hashcode >> User manager ::  " + manager1.hashCode()+" >> User :: "+manager1.getUser().hashCode());
	}
}

/**
 * output 
 * ======= 
 * UserManager [user=User [userId=1, username=jaikumar, age=22]]
 * Hashcode >> User manager :: 274773041 >> User :: 1629911510 
 * UserManager [user=User [userId=1, username=jaikumar, age=22]]
 *  Hashcode >> User manager :: 274773041 >> User :: 1629911510
 */