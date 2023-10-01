package com.practice.controller;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.CardPayment;
import com.practice.entity.ChequePayment;
import com.practice.utils.HibernateUtil;

public class InsertApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if (session != null) {
			Transaction transaction = null;
			Boolean flag = Boolean.FALSE;
			try {
				transaction = session.beginTransaction();

				CardPayment card = new CardPayment();
				card.setAmount(5000.0d);
				card.setId(1L);

				card.setCardNo(123);
				card.setHolderName("jai");
				card.setCardType("Credit");
				card.setPaymentGatway("VISA");
				session.save(card);

				ChequePayment cheque = new ChequePayment();
				cheque.setAmount(10000.0d);

				cheque.setCheqNo(523);
				cheque.setChequeType("physical");
				cheque.setDate(LocalDate.of(2023, 8, 3));
				session.save(cheque);

				flag = Boolean.TRUE;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}