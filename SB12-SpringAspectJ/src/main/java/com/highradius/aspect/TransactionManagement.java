package com.highradius.aspect;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	//For an particular method , multiple method acceptance
//	@Pointcut("execution(public void com.highradius.service.EmployeeService.getEmployee()) && execution(* * com.highradius.service.*.*())")

//	@Pointcut("execution(public void com.highradius.serviice.EmployeService.getEmployee())")
//	public void p1() {}
//	
//	@Before("p1()")
//	public void beforeMethod() {
//		System.out.println("TransactionManagement.beforeMethod()");
//	}
	
//	@Before("execution(* com.highradius.service.EmployeeService.getEmployee() && @annotation(CustomAnnotation))")
	@Before("@annotation(com.highradius.annotation.CustomAnnotation)")
	public void doAccessCheck() {
		ThreadContext.put("accountId","1");
		System.out.println("TransactionManagement.doAccessCheck()");
	}
	
	@After("@annotation(com.highradius.annotation.CustomAnnotation)")
	public void postCheck() {
		System.out.println("TransactionManagement.postCheck() >> "+ThreadContext.get("accountId"));
		ThreadContext.put("accountId","");
		System.out.println("TransactionManagement.postCheck() >> post clearing :: "+ThreadContext.get("accountId"));
	}
	
//	
//	// Any method inside service package classes
//	@Pointcut("execution(* * com.highradius.service.*.*())")
//	public void p2() {}
//	
//	
//	
	// For multiple pointCut
//	@Before("p1()") // JoinPoint
//	public void beginTransaction() {
//		System.out.println("TransactionManagement.beginTransaction()");
//	}
//	
//	// For multiple pointcut
//	@After("p1()") // JoinPoint
//	public void commitTransaction() {
//		System.out.println("TransactionManagement.commitTransaction()");
//	}
}