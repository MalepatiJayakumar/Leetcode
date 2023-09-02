package com.practice.update;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * If we are setting any values to the current db object then by default
 * synchronization will happen between an java object and L1 cache object
 * present in session. So once we do commit Database will be synced with L1
 * cache so without using update() method explicitly also data will be updated
 * in database. But these should happen with in an transaction. If there is some
 * difference in data then only update query will be generated otherwise updated
 * query won't be generated.
 * 
 * @author malep
 */
public class UpdateWithTransactionApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if (session != null) {
			Employee emp = session.get(Employee.class, 1L);
			Transaction transaction = session.beginTransaction();
			try {
				emp.setEmpName("jaikumar");
				emp.setEmpOrganization("HRC-01");
				emp.setLocation("HYD");
//				session.update(emp);
			} catch (HibernateException e) {
				System.out.println("Exception occurred :: " + e);
			} catch (Exception e) {
				System.out.println("Generic exception occurred  :: " + e);
			} finally {
				transaction.commit();
				HibernateUtil.closeSession(session);
			}
		}
	}
}