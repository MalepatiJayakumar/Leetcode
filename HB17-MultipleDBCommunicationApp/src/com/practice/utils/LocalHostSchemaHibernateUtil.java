package com.practice.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LocalHostSchemaHibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	static {
		sessionFactory = new Configuration().configure("localhost-hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static Session getSession() {
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		if(session != null) {
			session.clear();
		}
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}
}