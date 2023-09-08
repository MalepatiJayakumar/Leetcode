package com.practice.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

/**
 * When we use saveOrUpdate method it will try to save object in DB if we are
 * creating an new object , so here we have created an new Object of
 * InsurancePolicy ip2 so we will get below Exception.
 * 
 * Exception occurred while saving the Insurance Policy ::
 * org.hibernate.NonUniqueObjectException: A different object with the same
 * identifier value was already associated with the session :
 * [com.practice.entity.InsurancePolicy#1]
 * 
 * 
 *	To solve these problem and merge L1 cache (ip1) object and newly created object we use merge method. 
 * @author malep
 */
public class SaveOrUpdateApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		InsurancePolicy ip1 = null;
		InsurancePolicy ip2 = null;
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

				session.saveOrUpdate(ip2);
				System.out.println("Hashcode of Insurance Policy 1 :: " + ip1);
				System.out.println("Hashcode of Insurance Policy 2 :: " + ip2);

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