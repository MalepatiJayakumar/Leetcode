package com.practice.controller;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class FetchUserPolicies {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		String user = "JaiKumar Reddy";
		
		List<InsurancePolicy> insurancePolicies = session
				.createQuery("from InsurancePolicy ip where holderName in (:names)", InsurancePolicy.class)
				.setParameter("names", Arrays.asList(user)).getResultList();
		
		System.out.println("Total number of policies for "+user+" is :: "+insurancePolicies.size());
	}
}