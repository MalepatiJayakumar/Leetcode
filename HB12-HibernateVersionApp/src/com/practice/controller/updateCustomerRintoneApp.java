package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.MobileCustomer;
import com.practice.utils.HibernateUtil;

public class updateCustomerRintoneApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		MobileCustomer customer = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				customer = session.get(MobileCustomer.class,1);
				System.out.println("Version count before updating the record :: "+customer.getVersionCount());
				customer.setRingTone("Hye bama");
			}catch(Exception e) {
				System.out.println("Exception occurred :: "+e);
			}finally {
				transaction.commit();
				System.out.println("Version count after updating the record :: "+customer.getVersionCount());
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}
