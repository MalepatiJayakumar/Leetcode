package com.practice.controller.nonselect;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.utils.HibernateUtil;

public class BulkUpdate {
	public static void main(String[] args) {
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		try {
			transaction = session.beginTransaction();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter pk id to update tenure :: ");
			Long id = scan.nextLong();
			System.out.println("Enter number of years to increase :: ");
			Integer tenure = scan.nextInt();
			count = session.createQuery("update InsurancePolicy set tenure = tenure+:addedTenure where id=:id")
					.setParameter("addedTenure", tenure).setParameter("id", id).executeUpdate();
			flag = true;
			scan.close();
		} catch (Exception e) {
			System.out.println("Exception occurred :: " + e);
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of rows affected :: " + count);
			} else {
				System.out.println("Update operation failed");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}
}
