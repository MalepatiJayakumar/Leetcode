package com.practice.controller;

import com.practice.dao.InsurancePolicyDao;
import com.practice.daoFactory.InsurancePolicyDaoFactory;

public class CopyDataToBackUpTable {
	public static void main(String[] args) {
		InsurancePolicyDao insurancePolicyDao = InsurancePolicyDaoFactory.getInsurancePolicyDao();
		String result = insurancePolicyDao.copyPolicies();
		System.out.println(result);
	}
}