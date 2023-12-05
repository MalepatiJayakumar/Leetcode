package com.highradius.service;

import java.util.List;

import com.highradius.dto.CovidVaccineDTO;

public interface VaccineService {
	
	public List<CovidVaccineDTO> getCountryVaccines(String country);
}