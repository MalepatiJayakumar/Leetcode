package com.highradius.service;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;

import com.highradius.annotation.AccountLocalThreadManagement;

@Service
public class EmployeeService implements IEmployeeService {

	@Override
	@AccountLocalThreadManagement("thread")
	public String getEmployee() throws Exception {
		System.out.println("EmployeeService.getEmployee() >> accountId :: " + ThreadContext.get("accountId"));
		test();
		System.out.println("EmployeeService.getEmployee() >> accountId :: "+ThreadContext.get("accountId"));
//		throw new Exception("test");
		return "success";
	}
	
	public void test() {
		System.out.println("EmployeeService.test() >> accountId :: "+ThreadContext.get("accountId"));
		System.out.println("EmployeeService.test()");
	}
}