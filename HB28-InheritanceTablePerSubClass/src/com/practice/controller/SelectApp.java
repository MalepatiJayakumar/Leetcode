package com.practice.controller;

import java.util.List;

import org.hibernate.Session;

import com.practice.entity.CardPayment;
import com.practice.entity.ChequePayment;
import com.practice.entity.Payment;
import com.practice.utils.HibernateUtil;

public class SelectApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			try {
				/* Here we get all the payments irrespective of the transaction type*/
				List<Payment> payments = session.createQuery("from Payment",Payment.class).getResultList();
				payments.forEach(System.out::println);
				
				/* Here we are only fetching card payments*/
				List<CardPayment> cardPayment = session.createQuery("from CardPayment",CardPayment.class).getResultList();
				cardPayment.forEach(System.out::println);
				
				/* Here we are fetching all the cheque payments */
				List<ChequePayment> chequePayments = session.createQuery("from ChequePayment",ChequePayment.class).getResultList();
				chequePayments.forEach(System.out::println);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}