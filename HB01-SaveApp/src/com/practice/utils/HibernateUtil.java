package com.practice.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Employee;
import com.practice.entity.Student;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private static Session session = null;

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Student.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory(SessionFactory sessionFactory) {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
