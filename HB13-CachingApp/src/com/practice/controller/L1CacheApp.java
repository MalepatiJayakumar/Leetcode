package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class L1CacheApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if (session != null) {
			InsurancePolicy policy1 = session.get(InsurancePolicy.class, 1L); // get entry from DB as it was first time
																				// won't be available in Cache , query
																				// will be generated
			System.out.println("First policy :: " + policy1);
			System.out.println("------------------------------");

			InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L); // As we fetched for first time before ,
																				// it
																				// will be available in cache so it will
																				// fetch from Cache so query shouldn't
																				// be generated
			System.out.println("Policy :: " + policy2);
			System.out.println("------------------------------");
			/*
			 * Hibernate: select insurancep0_.policyNo as policyno1_0_0_,
			 * insurancep0_.companyName as companyn2_0_0_, insurancep0_.holderName as
			 * holderna3_0_0_, insurancep0_.policyName as policyna4_0_0_,
			 * insurancep0_.tenure as tenure5_0_0_ from InsurancePolicy insurancep0_ where
			 * insurancep0_.policyNo=? 
			 * Zero args constructor in InsurancePolicy 
			 * First policy :: InsurancePolicy [policyNo=1, policyName=jeevan Arogya, companyName=Star
			 * Health Insurance, holderName=Jaikumar reddy, tenure=5]
			 * ------------------------------ 
			 * Policy :: InsurancePolicy [policyNo=1,
			 * policyName=jeevan Arogya, companyName=Star Health Insurance,
			 * holderName=Jaikumar reddy, tenure=5] ------------------------------
			 */
			
			session.evict(policy1);// These will delete the cache data in Cache memory
			InsurancePolicy policy3 = session.get(InsurancePolicy.class,1L); // Here it will hit DB again to get the data
			System.out.println(policy3);

			session.clear(); // clears all the data in cache
			
		}
	}
}