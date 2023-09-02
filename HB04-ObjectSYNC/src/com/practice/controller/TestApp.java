package com.practice.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * With in an same transaction both L1 cache object and java object will always
 * be in sync if we are changing in java object, But if we are changing in
 * physical database data then java object won't be in sync. If we want then to
 * be in sync we need to refresh the session.
 * 
 * But If we are working within an transaction then even if we perform session
 * refresh object won't be refreshed.
 * 
 * @author malep
 */
public class TestApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if (session != null) {
//			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = session.get(Employee.class, 1L);
				System.out.println("Employee object before refreshing the session :: " + emp);
				System.in.read();
				session.refresh(emp); // To make
				System.out.println("Employee object post refreshing the session :: " + emp);
			} catch (HibernateException e) {
				System.out.println("Exception occurred while processing in Hibernate :: " + e);
			} catch (Exception e) {
				System.out.println("Exception occurred out of hibernate :: " + e);
			} finally {
//				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}