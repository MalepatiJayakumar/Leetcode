package com.practice.setterInheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		Employee emp1 = factory.getBean("emp1",Employee.class);
		System.out.println("Employee 1 :: "+emp1);
		
		Employee emp2 =factory.getBean("emp2",Employee.class);
		System.out.println("Employee 2 :: "+emp2);
	}
}
/**output
 * ======
 * Employee 1 :: Employee [id=1, name=Jaikumar, age=22, orgName=HighRadius Pvt Technologies, location=Hyderabad, dept=Product]
 * Employee 2 :: Employee [id=2, name=Archi, age=23, orgName=HighRadius Pvt Technologies, location=Hyderabad, dept=Product]
 */