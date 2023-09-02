package com.practice.saveUpdate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * Here i used saveOrUpdate method to save an entity into DB. so hibernate first
 * fires an select query to check weather we have an DB data or not. If no entry
 * is present for that pkId then it will save into Database , otherwose it will
 * update the existing record in DB.
 * 
 * 1. Also if we are just creating an new object and setting values with in an
 * transaction also , data won't persist in db without using methods to save /
 * update. Because these is an newly created java object which Hibernate L1
 * cache is not aware.
 * 
 * @author malep
 */
public class saveUpdateApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setEmpId(2L);
				emp.setEmpName("Dhanush");
				emp.setEmpOrganization("PW");
				emp.setSalary(1500d);
				emp.setLocation("BLR");
				session.saveOrUpdate(emp);
				emp.setEmpOrganization("WIPRO"); // These will be updated into DB
			} catch (Exception e) {
				System.out.println("Exception occurred :: " + e);
			} finally {
				transaction.commit();
				HibernateUtil.closeSession(session);
			}
		}
	}
}