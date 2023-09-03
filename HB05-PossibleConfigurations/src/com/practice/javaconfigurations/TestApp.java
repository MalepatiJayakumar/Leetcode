package com.practice.javaconfigurations;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Employee;

/**
 *  Hibernate configurations through pure java code
 * 
 * @author malep
 */

public class TestApp {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		
		// Here we use setProperty , where configure() method will read from file directly but here we are setting each property manually
		config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/localhost");
		config.setProperty("hibernate.connection.username","root");
		config.setProperty("hibernate.connection.password","Reddy@3816");
		//OPTIONAL PARAMETERS
		config.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		config.setProperty("hibernate.show_sql","true");
		config.setProperty("hibernate.format_sql","true");
		config.setProperty("hibernate.hbm2ddl.auto","update");
		config.addAnnotatedClass(Employee.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Employee emp = session.get(Employee.class,1L);
			System.out.println(emp);
		}catch(Exception e) {
			System.out.println("Exception occurred :: "+e);
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
