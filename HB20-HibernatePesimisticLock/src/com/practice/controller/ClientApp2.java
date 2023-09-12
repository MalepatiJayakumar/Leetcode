package com.practice.controller;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class ClientApp2 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				InsurancePolicy policy = session.get(InsurancePolicy.class,1L,LockMode.UPGRADE_NOWAIT);
				policy.setHolderName("kumar");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}