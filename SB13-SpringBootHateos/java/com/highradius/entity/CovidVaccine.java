package com.highradius.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidVaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String vaccineType;

	private String companyName;

	private String country;

	private Double price;
	
	public CovidVaccine() {
		super();
	}

	public CovidVaccine(Long id, String vaccineType, String companyName, String country, Double price) {
		this.id = id;
		this.vaccineType = vaccineType;
		this.companyName = companyName;
		this.country = country;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CovidVaccine [id=" + id + ", vaccineType=" + vaccineType + ", companyName=" + companyName + ", country="
				+ country + ", price=" + price + "]";
	}
}