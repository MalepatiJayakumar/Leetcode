package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

public class LoadAndDeleteApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = session.get(Employee.class,1L);
				if(emp != null) {
					session.delete(emp);
				}
			}catch(Exception e) {
				System.out.println("Exception occurred while doing an delete operation :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}
