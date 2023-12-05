package com.highradius.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TestAOP {

	@Before(value = "com.highradius.service.EmployeeService.getEmployeeOnId() && target(bean)", argNames = "bean")
	public void beforeMethod(Object bean) {
		System.out.println("TestAOP.beforeMethod() >> " + bean.getClass().getSimpleName());
	}
}