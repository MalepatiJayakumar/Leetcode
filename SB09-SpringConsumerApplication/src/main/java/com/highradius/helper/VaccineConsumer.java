package com.highradius.helper;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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

	// We use sync interservice calls to perform an dependent operations
	public static List<CovidVaccineDTO> getCovidVaccinesUsingWebClientSync() {
		System.out.println("VaccineConsumer.getCovidVaccinesUsingWebClientSync() >> execution started");
		WebClient webClient = WebClient.create();
		List<CovidVaccineDTO> response = webClient.
											get().
											uri("http://localhost:9090/covid/vaccine/get-all-vaccines").
											accept(MediaType.APPLICATION_JSON).
											retrieve().
											bodyToMono(new ParameterizedTypeReference<List<CovidVaccineDTO>>() {}).
											block();
		System.out.println("Inside getCovidVaccinesUsingWebClientSync response >> "+response);
		return response;
	}
	
	// If we have an in dependent operations which is like to push data through kafka we use Async Inter-service calls
	public static void getCovidVaccinesUsingWebClientAsync(){
		System.out.println("VaccineConsumer.getCovidVaccinesUsingWebClientAsync() >> execution started");
		WebClient webClient = WebClient.create();
		webClient.
											get().
											uri("http://localhost:9090/covid/vaccine/get-all-vaccines").
											accept(MediaType.APPLICATION_JSON).
											retrieve().
											bodyToMono(new ParameterizedTypeReference<List<CovidVaccineDTO>>() {}).
											subscribe(VaccineConsumer::performDataOperations);
		System.out.println("VaccineConsumer.getCovidVaccinesUsingWebClientAsync() >> execution ended");
	}
	
	public static void performDataOperations(List<CovidVaccineDTO> response) {
		//Perform operations with response that we got from async Interservice calls
		System.out.println("Inside performDataOperations response >> "+response);
	}
	
	public static List<CovidVaccineDTO> getVaccinesOnSortedOrderPOSTSYNC() {
		WebClient webClient = WebClient.create();
		List<CovidVaccineDTO> response = webClient.post()
				 .uri("http://localhost:9090/covid/vaccine/get-on-sorted-order/DESC")
				 .accept(MediaType.APPLICATION_JSON)
				 .body(BodyInserters.fromValue(Arrays.asList("id")))
				 .retrieve()
				 .bodyToMono(new ParameterizedTypeReference<List<CovidVaccineDTO>>() {})
				 .block();
		return response;
	}
}