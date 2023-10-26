package com.highradius;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.highradius.configuration.Configuration1;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);
		App app = context.getBean(App.class);
		System.out.println(app.test());
		((AbstractApplicationContext) context).close();
	}
}