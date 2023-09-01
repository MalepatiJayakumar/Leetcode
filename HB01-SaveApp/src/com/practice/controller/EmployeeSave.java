package com.practice.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Employee;


public class EmployeeSave {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		Transaction transaction = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEmpId(1l);
		emp.setEmpName("Jayakumar");
		emp.setEmpOrganization("HRC");
		emp.setSalary(5000d);
		emp.setLocation("HYD");
		
		session.save(emp);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
}
