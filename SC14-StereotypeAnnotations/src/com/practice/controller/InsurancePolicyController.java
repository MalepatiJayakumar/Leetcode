package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practice.service.InsurancePolicyService;

@Controller
public class InsurancePolicyController {
	
	@Autowired
	private InsurancePolicyService insurancepolicyService;
	
	public void saveInsurancePolicy() {
		insurancepolicyService.saveInsurancePolicy();
	}
}