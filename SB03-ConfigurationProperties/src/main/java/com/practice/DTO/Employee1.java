package com.practice.DTO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="emp1.info")
public class Employee1 {
	
	private Long id;
	private String name;
	private String[] skills;
	private List<String> teamMates;
	private Set<String> phoneNumbers;
	private Map<String,String> idDetails;
	
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public List<String> getTeamMates() {
		return teamMates;
	}

	public void setTeamMates(List<String> teamMates) {
		this.teamMates = teamMates;
	}

	public Map<String, String> getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(Map<String, String> idDetails) {
		this.idDetails = idDetails;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", skills=" + Arrays.toString(skills) + ", teamMates="
				+ teamMates + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", company=" + company
				+ "]";
	}

}