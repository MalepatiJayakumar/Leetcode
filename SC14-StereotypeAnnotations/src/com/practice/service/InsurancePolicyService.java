package com.practice.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.InsurancePolicyDAO;

@Service
public class InsurancePolicyService {

	@Autowired
	private InsurancePolicyDAO insurancePolicyDAO;
	
	static {
		System.out.println("InsurancePolicyService.class file has been loaded");
	}
	
	public InsurancePolicyService() {
		System.out.println("InsurancePolicyService object has been instantiated");
	}

	public String saveInsurancePolicy(){
		Integer count = insurancePolicyDAO.saveInsurancePolicy();
		return count > 0 ? "success" : "failed";
	}

}