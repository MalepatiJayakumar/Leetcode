package com.highradius.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CovidVaccineDTO {
	
	private Long id;

	private String vaccineType;

	private String companyName;

	private String country;

	private Double price;

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
		return "CovidVaccineDTO [id=" + id + ", vaccineType=" + vaccineType + ", companyName=" + companyName
				+ ", country=" + country + ", price=" + price + "]";
	}
}