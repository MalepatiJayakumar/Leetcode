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
		// Doing an interservice call using RestTemplate which is not preferable
//		List<CovidVaccineDTO> response = VaccineConsumer.getCovidVaccines();

		// Doing an interservice call using WebClient from WebFlux which is preferable
		List<CovidVaccineDTO> response = VaccineConsumer.getCovidVaccinesUsingWebClientSync();

		if (response == null || response.isEmpty()) {
			return null;
		}
		// Just trigger an inter-service in async for testing purpose
		VaccineConsumer.getCovidVaccinesUsingWebClientAsync();
		return response.stream().filter(vaccine -> vaccine.getCountry().equalsIgnoreCase(country))
				.collect(Collectors.toList());
	}

	@Override
	public List<CovidVaccineDTO> getVaccinesOnSortedOrder() {
		return VaccineConsumer.getVaccinesOnSortedOrderPOSTSYNC();
	}
}