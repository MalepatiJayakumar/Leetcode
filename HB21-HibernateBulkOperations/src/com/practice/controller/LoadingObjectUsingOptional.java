package com.practice.controller;

import java.util.Optional;
import java.util.Scanner;

import org.hibernate.Session;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class LoadingObjectUsingOptional {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		System.out.println("Enter pk id for getting Insurance policies :: ");
		Scanner scan = new Scanner(System.in);
		Long id = scan.nextLong();

		Optional<InsurancePolicy> insurancePolicies = session
				.createQuery("from InsurancePolicy ip where id=:id", InsurancePolicy.class).setParameter("id", id)
				.uniqueResultOptional();
		if (insurancePolicies.isPresent()) {
			System.out.println(insurancePolicies);
		} else {
			System.out.println("Policy is not present for pk id :: " + id);
		}
		scan.close();
	}
}