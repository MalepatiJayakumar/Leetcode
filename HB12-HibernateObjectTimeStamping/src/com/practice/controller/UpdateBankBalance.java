package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.BankAccount;
import com.practice.utils.HibernateUtil;

public class UpdateBankBalance {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		BankAccount account = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				account = session.get(BankAccount.class,1L);
				if(account == null) {
					return;
				}
				System.out.println("Account found with data :: "+account);
				account.setBalance(1200.0);
			}catch(Exception e) {
				System.out.println("Exception occurred :: "+e);
			}finally {
				transaction.commit();
				System.out.println("Account post updating the balance :: "+account);
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}
