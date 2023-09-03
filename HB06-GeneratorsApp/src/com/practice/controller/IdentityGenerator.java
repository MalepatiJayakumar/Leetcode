package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;
/**
 * An new table will be created for next value when we use identitys.
 * @GenericGenerator(name="value1" , strategy="identity")
	@GeneratedValue(generator="value1") 
 * @author malep
 */
public class IdentityGenerator {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			try {
				Employee emp = new Employee();
				emp.setName("JAIKUMAR");
				emp.setOrganization("AMZ");
				emp.setLocation("BLR");
				emp.setSalary(17000d);
				Long id = (Long)session.save(emp);
				System.out.println("Employee has been saved with id :: "+id);
			}catch(Exception e) {
				System.out.println("Exception occurred :: "+e);
			}finally {
				HibernateUtil.closeSession();
			}
		}
	}
}