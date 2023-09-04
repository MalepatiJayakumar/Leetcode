package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class SaveInsuracePolicyApp {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				InsurancePolicy policy = new InsurancePolicy();
				policy.setPolicyName("jeevan Arogya");
				policy.setCompanyName("Star Health Insurance");
				policy.setHolderName("Jaikumar reddy");
				policy.setTenure(5);
				id = (Long) session.save(policy);
			}catch(Exception e) {
				System.out.println("Exception occurred :: "+e);
			}finally {
				transaction.commit();
				System.out.println("Insurance policy has been saved with id :: "+id);
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}