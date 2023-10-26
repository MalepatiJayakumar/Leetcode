package com.highradius;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.highradius.configuration.Configuration1;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);
		App app = context.getBean(App.class);
		System.out.println("Total number if employees :: " + app.getEmployeeCount());
		System.out.println("Employee name :: " + app.getEmployeeNameById(1));
		System.out.println("Employee Details by Id :: " + app.getEmployeeById(1));
		System.out.println("Employee Details where location in HYD & BLR :: " + app.getEmployeesByLocation("HYD", "BLR"));

		/** Inserting an new employee **/
//		System.out.println(app.insertEmployee("Saravana", 24, "STVD", 61000.0d) > 0 ? "Record has been inserted successfully"
//				: "Inserting an Record has been failed");
		
		/** Updating employee salary based on location **/
		System.out.println("Number of employees salary modified :: "+app.updateSalary("HYD",1000.0));
		
		
		
		((AbstractApplicationContext) context).close();
	}
}