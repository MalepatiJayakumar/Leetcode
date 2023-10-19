package com.practice.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * BULK PROPERTIES LOADING
 * =======================
 * Reads all the data from application.properties ,if we want to read from any
 * other properties file then we need to mention that filePath
 * using @PropertySource(value="path") , And we need to give commom path like
 * emp.info.name --> emp.info is an common path and reads all the data which
 * starts with that. If names as same as variable name then we don't need to
 * write @Value(${"name"}) otherwise we need to write @Value annotation with
 * field name.
 *
 */
@Configuration
@ConfigurationProperties("emp.info")
public class Employee {

	private String name;
	private String address;
	private String organization;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", organization=" + organization + ", age=" + age
				+ "]";
	}
}