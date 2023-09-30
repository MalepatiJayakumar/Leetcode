package com.practice.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.HibernateUtil;

public class RestrictionsCretianAPI {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null)
		{
			try {
				Criteria criteria = session.createCriteria(InsurancePolicy.class);
				
				SimpleExpression restriction = Restrictions.ge("tenure",9);
				criteria.add(restriction);
				
				Order order = Order.desc("id");
				criteria.addOrder(order);
				
				List<InsurancePolicy> policies = criteria.list();
				policies.forEach(System.out::println);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}