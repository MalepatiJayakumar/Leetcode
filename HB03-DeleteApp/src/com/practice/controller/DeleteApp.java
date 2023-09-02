package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * Hibernate will check for the primary key in an entity that we deleting , if
 * that is present. Then hibernate will fire an select query to get the record ,
 * If record is present then one more query will be generated for deleting the
 * record.
 * 
 * @author malep
 */
public class DeleteApp {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setEmpId(2L);
				session.delete(emp);
			}catch(Exception e) {
				System.out.println("Exception occurred while deleting an employee :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
			}
		}
	}
	
}
