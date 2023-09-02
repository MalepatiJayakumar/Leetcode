package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Student;
import com.practice.utils.HibernateUtil;

public class GetStudentApp {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction(); // we don't need transaction for select operation
		Long id = 10l;
		try {
			Student student = session.get(Student.class, id);
			if (student != null) {
				System.out.println("Record found for provided Id :: " + id);
				System.out.println(student);
			} else {
				System.out.println("Record not found for provided Id :: " + id);
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while getting the record :: " + e);
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory(sessionFactory);
		}
	}
}