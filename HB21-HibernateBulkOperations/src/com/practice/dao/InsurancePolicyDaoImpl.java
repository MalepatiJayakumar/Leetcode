package com.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.utils.HibernateUtil;

/*
 * We can write query as below which is commented or if we want to use the same query
 *  in multiple dao layers we need to write everywhere instead of that we can write in 
 *  entity itself by used @NamedQuery annotation where it can be used everywhere.
 */
public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

//	private static final String INSURANCE_POLICY_COPY_QUERY = "insert into InsurancePolicyBackUp(id,policyName,holderName,tenure,versioncount)"
//			+ " select ip.id,ip.policyName,ip.holderName,ip.tenure,ip.versioncount from InsurancePolicy as ip";
	Session session = null;
	Transaction transaction = null;
	boolean flag = false;
	int count = 0;
	String msg = null;
	
	@Override
	public String copyPolicies() {
		session = HibernateUtil.getSession();
		if(session != null) {
			transaction = session.beginTransaction();
			try {
//				count = session.createQuery(INSURANCE_POLICY_COPY_QUERY).executeUpdate();
				count = session.createNamedQuery("INSURANCE_POLICY_COPY_QUERY").executeUpdate();
				flag = true;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(flag) {
					msg = count+" number of rows has been copied";
				}else {
					msg = "copying the Insurance Policies data has been failed";
				}
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
		return msg;
	}
}