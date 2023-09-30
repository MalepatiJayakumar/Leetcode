package com.practice.controller;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class SelectFilterApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			try {
				Filter filter = session.enableFilter("FILTER_INSURANCE_POLICY");
				filter.setParameter("delete",1);
				System.out.println("**********Active policies***********");
				List<InsurancePolicy> activePolicies = session.createQuery("from InsurancePolicy where tenure>:tenure",InsurancePolicy.class).setParameter("tenure",5).getResultList();
				activePolicies.forEach(System.out::println);
				
				// From here we are disabiling the filters
				System.out.println("**********All policies***********");
				session.disableFilter("FILTER_INSURANCE_POLICY");
				List<InsurancePolicy> allPolicies = session.createQuery("from InsurancePolicy where tenure>:tenure",InsurancePolicy.class).setParameter("tenure",5).getResultList();
				allPolicies.forEach(System.out::println);

				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}