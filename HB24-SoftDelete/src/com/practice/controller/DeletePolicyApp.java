package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;
/*
 * Delete App is not working
 */
public class DeletePolicyApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Boolean flag = Boolean.FALSE;
		if(session != null) {
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				InsurancePolicy policy = new InsurancePolicy();
				policy.setId(1L);
				session.delete(policy);
				flag = Boolean.TRUE;
			}catch(Exception e) {
				System.out.println(e);
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