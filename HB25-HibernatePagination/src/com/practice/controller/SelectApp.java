package com.practice.controller;

import java.util.List;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class SelectApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			try {
				List<InsurancePolicy> policies = session.createQuery("from InsurancePolicy",InsurancePolicy.class).setFirstResult(0).setMaxResults(2).getResultList();
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