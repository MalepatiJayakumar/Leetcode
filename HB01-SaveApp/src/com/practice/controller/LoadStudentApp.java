package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.Student;
import com.practice.utils.HibernateUtil;

/**
 * 
 * @author malep
 * 
 * @see session.load(object.class,id) --> prepares as proxy object and sets id
 *      to that proxy object. Untill we use getter of any non primary key
 *      Hibernate(ORM) won't hit any query to DB engine. Once we use getter of
 *      any non-primary key ORM fires an query and prepares an new object and
 *      assign to that variable. So load is an lazy fetching object
 */
public class LoadStudentApp {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Student student = session.load(Student.class,10L);
			if(student != null) {
				System.out.println("student id :: "+student.getId());
				System.in.read(); // Till here there won't be any db hit , because id will be available in proxy object
				System.out.println("student name :: "+student.getName()); // On one time hit for non-primary key everything will be fetched in that object
				System.in.read();
				System.out.println("student object :: "+student);
			}
		}catch(Exception e) {
			System.out.println("Exception occurred while getting student data using load() :: "+e);
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory(sessionFactory);
		}
		
	}
}
