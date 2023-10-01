package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Address;
import com.practice.entity.StudentInfo;
import com.practice.utils.HibernateUtil;

public class InsertApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Boolean flag = Boolean.FALSE;
		if(session != null) {
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Address address = new Address("HYD","TELANGANA","IND");
				StudentInfo info = new StudentInfo("JAI","CSE",address);
				session.save(info);
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