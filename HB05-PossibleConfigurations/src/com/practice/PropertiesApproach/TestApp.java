package com.practice.PropertiesApproach;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Employee;

/**
 * In these example we hibernate configurations will be loaded from
 * hibernate.properties file , whereas in properties file we won't be able to
 * provide the annotated entity class , so we need to set annotated class
 * explicitly using addAnnotatedClass method in @Configuration class.
 * 
 * @author malep
 */
public class TestApp {
	public static void main(String[] args) {
		Configuration configuration = new Configuration(); // It will search for hibernate.properties file, as we
															// created so it will load all properties from that file
		configuration.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		if(session != null) {
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
}