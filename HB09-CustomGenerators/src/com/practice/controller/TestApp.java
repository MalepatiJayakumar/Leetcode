package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

public class TestApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		String id = null;
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setName("jayakumar");
				emp.setOrganization("HRC");
				emp.setLocation("HYD");
				emp.setSalary(1000d);
				id = (String) session.save(emp);
				System.out.println("Employee saved with id :: " + id);
			} catch (Exception e) {
				System.out.println("Exception occurred :: " + e);
			} finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}