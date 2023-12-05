package com.highradius.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.helper.VaccineConsumer;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Override
	public List<CovidVaccineDTO> getCountryVaccines(String country) {
		List<CovidVaccineDTO> response = VaccineConsumer.getCovidVaccines();
		if (response == null || response.isEmpty()) {
			return null;
		}
		return response.stream().filter(vaccine -> vaccine.getCountry().equalsIgnoreCase(country))
				.collect(Collectors.toList());
	}
}