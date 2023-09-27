package com.practice.controller;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class PartialLoading {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		String user = "JaiKumar Reddy";
		
		@SuppressWarnings("unchecked")
		List<Object[][]> data = session.createQuery("select holderName,policyName,tenure from InsurancePolicy ip where holderName in (:names)")
		.setParameter("names", Arrays.asList(user)).getResultList();
		
		for(Object[] row : data) {
			for(Object data1 : row) {
				System.out.print(data1+" \t");
			}
			System.out.println();
		}
		
	}
}