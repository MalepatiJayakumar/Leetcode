package com.highradius.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	//For an particular method , multiple method acceptance
	@Pointcut("execution(public void com.highradius.service.EmployeeService.getEmployee()) && execution(* * com.highradius.service.*.*())")
	public void p1() {}
	// Any method inside service package classes
	@Pointcut("execution(* * com.highradius.service.*.*())")
	public void p2() {}
	
	
	
	// For multiple pointCut
	@Before("p1()") // JoinPoint
	public void beginTransaction() {
		System.out.println("TransactionManagement.beginTransaction()");
	}
	
	// For multiple pointcut
	@After("p1()") // JoinPoint
	public void commitTransaction() {
		System.out.println("TransactionManagement.commitTransaction()");
	}
}