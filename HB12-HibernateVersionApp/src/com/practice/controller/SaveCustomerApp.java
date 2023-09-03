package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.MobileCustomer;
import com.practice.utils.HibernateUtil;

public class SaveCustomerApp {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Integer id = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				MobileCustomer customer = new MobileCustomer("jaikumar","ra ra rakamma");
				id = (Integer)session.save(customer);
			}catch(Exception e) {
				System.out.println("Exception occurred  :: "+e);
			}finally {
				transaction.commit();
				System.out.println("Customer has been saved with id :: "+id);
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}