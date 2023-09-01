package com.practice.controller;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Student;
import com.practice.utils.HibernateUtil;

public class StudentSave {
	
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSession();
			transaction= session.beginTransaction();
			Student student = new Student(1L,"dhanush",19);
			session.save(student);
		} catch (HibernateException e) {

		} catch (Exception e) {

		} finally {
			if (transaction != null) {
				transaction.commit();
			}
			HibernateUtil.closeSession(session);
		}

	}

}
