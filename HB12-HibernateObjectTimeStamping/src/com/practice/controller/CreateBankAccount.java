package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.BankAccount;
import com.practice.utils.HibernateUtil;

public class CreateBankAccount {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				BankAccount account = new BankAccount("Jaikumar",1000.0);
				id = (Long)session.save(account);
				if(id != null) {
					System.out.println("Object created with id :: "+id);
				}
			}catch(Exception e) {
				System.out.println("Exception occurred  :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}