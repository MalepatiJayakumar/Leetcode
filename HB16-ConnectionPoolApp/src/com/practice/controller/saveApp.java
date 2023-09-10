package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.utils.HibernateUtil;
import com.practice.entity.InsurancePolicy;

/**
 * As we provided HikariCp as an provider class for connection pooling in
 * hibernate.cfg.xml , it will take the object from HikariCp connection pool.
 * Post completing the operations it will send those objects to Connection pool
 * again.
 * 
 * @author malep
 */
public class saveApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				InsurancePolicy ip = new InsurancePolicy();
				ip.setPolicyName("Jeevan Arogya");
				ip.setCompanyName("HDFC Health Insurance");
				ip.setHolderName("Dilli Babu");
				ip.setTenure(10);
				session.persist(ip);
			}catch(Exception e) {
				System.out.println("Exception occurred :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}