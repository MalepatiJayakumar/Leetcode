package com.practice.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

public class AddEmployeeApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Boolean flag = Boolean.FALSE;
		if(session != null) {
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				
				Set<Long> phones = new HashSet<>();
				phones.add(9515184639l);
				phones.add(21386532l);

				Map<String,Long> bankAccounts= new HashMap<>();
				bankAccounts.put("HDFC",1234l);
				bankAccounts.put("AXIS",6453l);
				
				Employee emp = new Employee();
				emp.setName("jaikumar");
				emp.setOrganization("Highradius Pvt Technologies");
				emp.setFriendsList(Arrays.asList("yash","gaurav","archi"));
				emp.setPhones(phones);
				emp.setBankAccounts(bankAccounts);
				
				session.save(emp);
				
				flag = Boolean.TRUE;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(flag) {
					transaction.commit();
				}else {
					transaction.rollback();
				}
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}