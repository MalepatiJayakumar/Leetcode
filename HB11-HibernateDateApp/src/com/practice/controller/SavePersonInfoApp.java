package com.practice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.PersonInfo;
import com.practice.utils.HibernateUtil;

public class SavePersonInfoApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Integer id = null;
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				PersonInfo personInfo = new PersonInfo();
				personInfo.setName("Jaikumar");
				// int year, Month month, int dayOfMonth, int hour, int minute
				personInfo.setDob(LocalDateTime.of(2001, 8, 03, 05, 45));
				// int year, Month month, int dayOfMonth
				personInfo.setDoj(LocalDate.of(2021, 8, 01));
				personInfo.setCurrentTime(LocalTime.of(20, 48));
				id = (Integer) session.save(personInfo);
				if (id != null) {
					System.out.println("Record has been added successfully with id :: " + id);
				} else {
					System.out.println("Adding person info has been failed");
				}
			} catch (Exception e) {
				System.out.println("Exception occurred while saving personInfo  :: " + e);
			} finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}