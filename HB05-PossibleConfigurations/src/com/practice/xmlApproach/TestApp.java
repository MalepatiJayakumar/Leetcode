package com.practice.xmlApproach;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Employee;

public class TestApp {
	public static void main(String[] args) {
		Configuration configuration = new Configuration(); // Searches for hibernate.properties file , loads properties if file exists
		configuration.configure(); // searched for hibernate.cfg.xml file & load the hibernate DB required properties
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		if(session != null) {
			try {
				Employee emp = session.get(Employee.class,1L);
				System.out.println(emp);
			}catch(Exception e)
			{
				System.out.println("Exception occurred :: "+e);
			}finally {
				session.close();
				sessionFactory.close();
			}	
		}
	}
}