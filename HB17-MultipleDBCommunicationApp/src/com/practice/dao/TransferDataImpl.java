package com.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.InsurancePolicy;
import com.practice.utils.LocalHostSchemaHibernateUtil;
import com.practice.utils.SakilaSchemaHibernateUtil;

public class TransferDataImpl implements ITransferData {

	Session localhostSession = null;
	Session sakilaSession = null;
	Transaction sakilaTransaction = null;
	
	@Override
	public String transferInsuranceData(Long policyNo) {
		localhostSession = LocalHostSchemaHibernateUtil.getSession();
		if(localhostSession != null) {
			InsurancePolicy policy = localhostSession.get(InsurancePolicy.class,policyNo);
			if(policy == null) {
				System.out.println("Record not found in localhost schema");
			}else {
				sakilaSession = SakilaSchemaHibernateUtil.getSession();
				if(sakilaSession != null) {
					sakilaTransaction = sakilaSession.beginTransaction();
					try {
						sakilaSession.save(policy);
						return "SUCCESS";
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						SakilaSchemaHibernateUtil.closeSession();
						SakilaSchemaHibernateUtil.closeSessionFactory();
					}
				}
			}
		}
		return "Failed";
	}

}
