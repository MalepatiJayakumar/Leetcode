package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.generators.WishMessageGenerator;

@SpringBootApplication
public class Sb01BasicSetupApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sb01BasicSetupApplication.class, args);
		System.out.println("Implementation class of container :: "+context.getClass().getName());

		WishMessageGenerator wmg = context.getBean(WishMessageGenerator.class);
		System.out.println(wmg);
		System.out.println(wmg.generateWishMessage("Jaikumar"));
	}
}