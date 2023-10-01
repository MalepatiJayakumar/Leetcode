package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.StudentInfo;
import com.practice.utils.HibernateUtil;

public class SelectApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			try {
				StudentInfo student = session.get(StudentInfo.class,1L);
				System.out.println(student);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}