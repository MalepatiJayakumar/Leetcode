package com.practice.controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * when we use @Id @GenericGenerator(name="value1" , strategy="increment")
 * 
 * @GeneratedValue(generator="value1") @Column(name="pk_id") private Long id;
 *                                     for the id then it will fire an query to
 *                                     get the max(pk_value) and then increments
 *                                     that max number for the current record
 *                                     primary key.
 *                                     
 * Output :- 
 * (select max(id) from org_employee)++ --> id 
 * 
 * @author malep
 */
public class TestApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setName("Dhanush");
				emp.setOrganization("Amazon");
				emp.setLocation("BLR");
				emp.setSalary(16000d);
				Long id = (Long)session.save(emp);
				System.out.println("Hibernate generated id is :: "+id);
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
