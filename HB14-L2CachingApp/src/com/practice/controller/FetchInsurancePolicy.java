package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class FetchInsurancePolicy {
	
	public static void main(String[] args) throws InterruptedException {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			InsurancePolicy policy1 = session.get(InsurancePolicy.class, 1L); // Fetches from DB as these is first time
																				// so data won't be available in L1 or L2 cache, so query will be generated
			System.out.println(policy1);
			System.out.println("----------------------------");
			
			InsurancePolicy policy2 = session.get(InsurancePolicy.class,1L); // As we have data in L1 cache it will fetch without query
			System.out.println(policy2);
			System.out.println("----------------------------");
			
			session.evict(policy2); //Clearing data in L1 cache
			
			InsurancePolicy policy3 = session.get(InsurancePolicy.class,1L); //As we enabled L2 cache object should fetch from there without query
			System.out.println(policy3);
			System.out.println("----------------------------");
			
			session.clear();// remove all objects from L1-cache

			Thread.sleep(20000);
			
			//As we kept time of 10sec for object expiry in L2 cache it should expire from L2 cache and need to fetch from query
			InsurancePolicy policy4 = session.get(InsurancePolicy.class,1L);
			System.out.println(policy4);
			System.out.println("----------------------------");
		}
	}
}