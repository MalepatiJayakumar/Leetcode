package com.practice.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {

	Session session = HibernateUtil.getSession();
	
	@Override
	public Boolean addEmployee(Employee employee) {
		Boolean status = Boolean.FALSE;
		Long id = null;
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				id = (Long) session.save(employee);
				status = Boolean.TRUE;
			} catch (Exception e) {

			} finally {
				if (status) {
					transaction.commit();
					System.out.println("Employee has been saved with id :: " + id);
				} else {
					transaction.rollback();
				}
				HibernateUtil.closeSession();
			}
		}
		return status;
	}

	@Override
	public Employee searchEmployee(Long id) {
		if (session != null) {
			return session.get(Employee.class, id);
		}
		return null;
	}

	@Override
	public Boolean deleteEmployee(Long id) {
		Boolean status = Boolean.FALSE;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = session.get(Employee.class,id);
				if(emp != null) {
					session.delete(emp);
					status = Boolean.TRUE;
				}
			}catch(Exception e) {
				System.out.println("Exception occurred while deleting an employee :: "+e);
			} finally {
				if (status) {
					transaction.commit();
					System.out.println("Employee has been deleted with id :: " + id);
				} else {
					transaction.rollback();
				}
				HibernateUtil.closeSession();
			}
		}
		return status;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}