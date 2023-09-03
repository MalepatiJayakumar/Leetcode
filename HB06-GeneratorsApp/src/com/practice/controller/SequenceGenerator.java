package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * @GenericGenerator(name="value1" , strategy="sequence")
 * 
 * @GeneratedValue(generator="value1") As we know sequence algorithm is for
 *                                     Oracle db , but still if we are using for
 *                                     MYSQL DB then , hibernate will create an
 *                                     new table for storing then next value ,
 *                                     and takes the values from that table for
 *                                     next time saving.
 *  In oracle we will have sequence , so these algorithm works fine with oravle.
 * 
 * @author malep
 *
 */
public class SequenceGenerator {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setName("DHANUSH");
				emp.setOrganization("AMZ");
				emp.setLocation("CHE");
				emp.setSalary(17000d);
				Long id = (Long)session.save(emp);
				System.out.println("Employee has been saved with id :: "+id);
			}catch(Exception e) {
				System.out.println("Exception occurred :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}