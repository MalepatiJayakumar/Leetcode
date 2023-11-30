package com.highradius.service;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;

import com.highradius.annotation.CustomAnnotation;

@Service
public class EmployeeService implements IEmployeeService {

	@Override
	@CustomAnnotation("thread")
	public String getEmployee() throws Exception {
		System.out.println("EmployeeService.getEmployee() >> accountId :: " + ThreadContext.get("accountId"));
		throw new Exception("test");
//		return "success";
	}
}