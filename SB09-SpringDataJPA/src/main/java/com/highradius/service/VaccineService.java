package com.highradius.service;

import java.util.List;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.type.ResultView1;
import com.highradius.type.View;

public interface VaccineService {
	public void saveCovidVaccineProvider(CovidVaccineDTO vaccine);
	public List<CovidVaccineDTO> getAllVaccines();
	public Long getVaccineCount();
	public List<CovidVaccineDTO> getVaccinesOnSortedOrder(String order, List<String> properties);
	public List<CovidVaccineDTO> getVaccinesForACompany(String companyName);
	public Iterable<ResultView1> getRequestData(String companyName);
	/*public Iterable<View> getVaccinesOnPrice(Double price ,String className); */
}