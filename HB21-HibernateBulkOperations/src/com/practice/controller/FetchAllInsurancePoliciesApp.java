package com.practice.controller;

import java.util.List;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class FetchAllInsurancePoliciesApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			List<InsurancePolicy> policies = session.createQuery("from InsurancePolicy",InsurancePolicy.class).getResultList();
			System.out.println("Total number of policies :: "+policies.size());
		}
	}
}