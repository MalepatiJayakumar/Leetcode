package com.practice.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

/**
 * Here we used merge operation so when ever we have an new object and merging
 * that , it will be refered to the L1 cache object if it is present and both L1
 * object which we got from DB and object which we created. And it will merge
 * the data and updates in DB once the transaction gets committed.
 * 
 * @author malep
 */
public class MergeApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		InsurancePolicy ip1 = null;
		InsurancePolicy ip2 = null;
		InsurancePolicy ip3 = null;
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				ip1 = session.get(InsurancePolicy.class, 1L);
				ip2 = new InsurancePolicy();
				ip2.setPolicyNo(1L);
				ip2.setPolicyName("Star Health Insurance");
				ip2.setCompanyName("jeevan Arogya");
				ip2.setHolderName("JaiKumar Reddy");
				ip2.setTenure(5);

				ip3 = (InsurancePolicy) session.merge(ip2);
				System.out.println("Hashcode of Insurance Policy 1 :: " + ip1);
				System.out.println("Hashcode of Insurance Policy 2 :: " + ip2);
				System.out.println("Hashcode of Insurance Policy 3 :: " + ip3);
			} catch (HibernateException e) {
				System.out.println("Exception occurred while saving the Insurance Policy :: " + e);
			} finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}
