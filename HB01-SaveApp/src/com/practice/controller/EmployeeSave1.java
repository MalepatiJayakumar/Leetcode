package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

public class EmployeeSave1 {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Employee emp = new Employee();
			emp.setEmpName("dhanush");
			emp.setEmpId(1l);
			emp.setLocation("chennai");
			session.persist(emp);
			/*
			 * As we are setting only there values , below query will be generated.
			 * Hibernate: insert into org_employee (name, location, pk_id)  values(?, ?, ?)
			 */
		}catch(Exception e) {
			System.out.println("Exception :: "+e);
		}finally {
			transaction.commit();
			HibernateUtil.closeSession(session);
		}
		
		
	}
}
