package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Student;

public class TestApp {
	
	public static void main(String[] args) {
		// 1. Inform JVM to activate HIBERNATE
				Configuration configuration = new Configuration();
				configuration.configure();

				// Creating a SessionFactory object to hold many other objects required for
				// HIBERNATE
				SessionFactory sessionFactory = configuration.buildSessionFactory();

				// Using SessionFactory object, get only one Session object to perform our
				// persistence operation
				Session session = sessionFactory.openSession();// connection object,ORM-dialects,L1-Cache,TXTManagement

				Transaction transaction = session.beginTransaction();// transaction.begin()

				// 2. Create PERSITENCE Object
				Student student = new Student();
				student.setId(10l);
				student.setAge(49);
				student.setName("sachin");

				// 3. Perform PERISTENCE operation using Entity/Model/POJO object
				session.persist(student);

				// 4. commit the operation based on the result
				transaction.commit();

				System.out.println("Object saved to database....");

				session.close();
				sessionFactory.close();

	}
}
