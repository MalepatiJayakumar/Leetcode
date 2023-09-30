package com.practice.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class BasicSelectCriterianAPI {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null)
		{
			try {
				Criteria criteria = session.createCriteria(InsurancePolicy.class);
				List<InsurancePolicy> policies = criteria.list();
				policies.forEach(System.out::println);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}