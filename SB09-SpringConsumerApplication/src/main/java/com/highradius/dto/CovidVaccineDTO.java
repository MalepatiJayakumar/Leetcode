package com.highradius.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "request")
@Getter
@Setter
public class CovidVaccineDTO {
	
	private Long id;

	private String vaccineType;

	private String companyName;

	private String country;

	private Double price;

	@Override
	public String toString() {
		return "CovidVaccineDTO [id=" + id + ", vaccineType=" + vaccineType + ", companyName=" + companyName
				+ ", country=" + country + ", price=" + price + "]";
	}
}