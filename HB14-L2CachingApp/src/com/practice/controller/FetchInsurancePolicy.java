package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;


public class FetchInsurancePolicy {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			InsurancePolicy policy1 = session.get(InsurancePolicy.class , 1L); // Fetches from DB and stores in L2 & L1 cache. So query will be generated here
			System.out.println("Policy1 :: "+policy1);
			System.out.println("---------------------------");
			
			InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L); // Here object will be present in L1 cache so takes from L1 cache without query
			System.out.println("Policy2 :: "+policy2);
			System.out.println("---------------------------");
			
			session.evict(policy2);//clearing the object from L1 cache
			
			InsurancePolicy policy3 = session.get(InsurancePolicy.class,1L);
			System.out.println("Policy3  :: "+policy3);
			System.out.println("---------------------------");
			
		}
	}
}
