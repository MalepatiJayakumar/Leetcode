package com.highradius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.service.VaccineService;

@RestController
@RequestMapping("/vaccine1")
public class VaccineController {

	@Autowired
	VaccineService vaccineService;

	@RequestMapping(value = "/get-vaccine-country-specific/{country}", method = RequestMethod.GET)
	public ResponseEntity<List<CovidVaccineDTO>> getCountryVaccines(@PathVariable String country) {
		return new ResponseEntity<>(vaccineService.getCountryVaccines(country), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-on-default-sorted-order", method = RequestMethod.GET)
	public ResponseEntity<List<CovidVaccineDTO>> getVaccinesOnSortedOrder() {
		return ResponseEntity.ok().body(vaccineService.getVaccinesOnSortedOrder());
	}
}