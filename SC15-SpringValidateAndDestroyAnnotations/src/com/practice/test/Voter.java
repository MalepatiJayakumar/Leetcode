package com.practice.test;

import java.util.Date;

//JDK supplied annotations will be available in JDK till jdk 8 version only. For Higher versions we need to add explicit jars.
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = { "application.properties" })
public class Voter {

	@Value("${voter.info.name}")
	private String name;
	
	@Value("${voter.info.age}")
	private Integer age;

	private Date dob;
	
	@PostConstruct
	public void preExecuterForValidations() {
		System.out.println("Voter.preExecuterForValidations()");
		StringBuilder msg = new StringBuilder();
		boolean isValid = Boolean.TRUE;
		if (BlankCheck(name)) {
			msg.append("voter name is mandatory for vote\n");
			isValid = Boolean.FALSE;
		}
		if (age == null) {
			msg.append("voter " + name + " age is not mentioned");
			if (age < 0) {
				age = age * -1;
			}
			isValid = Boolean.FALSE;
		}
		dob = new Date();

		if (!isValid) {
			throw new IllegalArgumentException(msg.toString());
		}
	}
	
	public String checkVoterEligibility() {
		System.out.println("Voter.checkVoterEligibility()");
		String msg = "Voter validation successfully completed";
		if(age < 18) {
			msg = "Voter is not eligible for voting";
		}
		return msg;
	}
	
	@PreDestroy
	public void doDestroy() {
		name = null;
		age = null;
		dob = null;
		System.out.println("Voter.doDestroy()");
	}
	
	public <T> Boolean BlankCheck(T obj) {
		return obj == null ? Boolean.TRUE : ((String) obj).trim().isEmpty() ? Boolean.TRUE : Boolean.FALSE;
	}
		
}