package com.practice.daoFactory;

import com.practice.dao.InsurancePolicyDao;
import com.practice.dao.InsurancePolicyDaoImpl;

public class InsurancePolicyDaoFactory {
	private static InsurancePolicyDao insurancePolicyDao = null;

	public static InsurancePolicyDao getInsurancePolicyDao() {
		if (insurancePolicyDao == null) {
			insurancePolicyDao = new InsurancePolicyDaoImpl();
		}
		return insurancePolicyDao;
	}
}