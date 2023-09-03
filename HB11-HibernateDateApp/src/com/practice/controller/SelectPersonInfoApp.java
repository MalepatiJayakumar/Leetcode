package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.PersonInfo;
import com.practice.utils.HibernateUtil;

public class SelectPersonInfoApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Integer id = 1;
		if(session != null) {
			PersonInfo personInfo  = session.get(PersonInfo.class,id);
			if(personInfo != null) {
				System.out.println(personInfo);
			}else {
				System.out.println("Record not found with id :: "+id);
			}
		}
	}
}