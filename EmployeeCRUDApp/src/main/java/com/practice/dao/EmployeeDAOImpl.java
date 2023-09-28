package com.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.Constants;
import com.practice.utils.HibernateUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {

	Session session = HibernateUtil.getSession();
	Transaction transaction = null;
	Boolean flag = Boolean.FALSE;
	
	@Override
	public String addEmployee(Employee emp) {
		String msg = null;
		transaction = session.beginTransaction();
		try {
			session.save(emp);
			flag = Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				msg = Constants.SUCCESS;
			} else {
				msg = Constants.FAILED;
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
		return msg;
	}

}
