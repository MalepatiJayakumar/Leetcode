package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class SaveInsurancePolicy {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				InsurancePolicy policy = new InsurancePolicy();
				policy.setPolicyName("HealthInsurance");
				policy.setHolderName("Dhanush");
				policy.setTenure(30);
				session.persist(policy);
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