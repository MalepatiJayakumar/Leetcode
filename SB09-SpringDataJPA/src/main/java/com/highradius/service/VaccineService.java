package com.highradius.service;

import java.util.List;

import com.highradius.dto.CovidVaccineDTO;

public interface VaccineService {
	public void saveCovidVaccineProvider(CovidVaccineDTO vaccine);
	public List<CovidVaccineDTO> getAllVaccines();
	public Long getVaccineCount();
	public List<CovidVaccineDTO> getVaccinesOnSortedOrder(String order, List<String> properties);
	public List<CovidVaccineDTO> getVaccinesForACompany(String companyName);
}