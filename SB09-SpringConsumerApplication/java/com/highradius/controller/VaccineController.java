package com.highradius.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	@RequestMapping(name = "/add-vaccine", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCovidVaccineProvider() {
		return ResponseEntity.ok().build();
	}
}