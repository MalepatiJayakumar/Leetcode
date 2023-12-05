package com.highradius.helper;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.highradius.dto.CovidVaccineDTO;

@Component
public class VaccineConsumer {

	public static List<CovidVaccineDTO> getCovidVaccines() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<List<CovidVaccineDTO>> responseBody = template.exchange(
				"http://localhost:9090/covid/vaccine/get-all-vaccines", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CovidVaccineDTO>>() {
				});
		return responseBody.getBody();
	}
}