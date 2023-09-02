package com.practice.update;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.Employee;
import com.practice.utils.HibernateUtil;

/**
 * @author malep
 * 
 * @see UPDATE() method in hibernate updates an record that is existing in DB ,
 *      otherwise it will throw exception Exception in thread "main"
 *      javax.persistence.OptimisticLockException: Batch update returned
 *      unexpected row count from update [0]; actual row count: 0; expected: 1;
 *      statement executed: update org_employee set name=?, organization=?,
 *      location=?, salary=? where pk_id=?
 *
 * 
 */
public class UpdateApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setEmpId(1l);
				emp.setEmpName("Mahesh");
				emp.setEmpOrganization("Wipro");
				emp.setSalary(1500d);
				emp.setLocation("BLR");
				session.update(emp);
			} catch (HibernateException e) {
				System.out.println("Hibernate exception :: " + e);
			} catch (Exception e) {
				System.out.println("Exception  :: " + e);
			} finally {
				transaction.commit();
				HibernateUtil.closeSession(session);
			}
		}
	}

}
