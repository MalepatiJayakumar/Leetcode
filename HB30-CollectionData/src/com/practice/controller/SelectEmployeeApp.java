package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

public class SelectEmployeeApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		try {
			Employee emp = session.get(Employee.class,1L);
			System.out.println(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}
}