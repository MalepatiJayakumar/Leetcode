package com.highradius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.service.VaccineService;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	@Autowired
	private VaccineService vaccineService;
	
	@RequestMapping(value = "/add-vaccine", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCovidVaccineProvider(@RequestBody CovidVaccineDTO vaccine) {
		vaccineService.saveCovidVaccineProvider(vaccine);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/get-all-vaccines" , method=RequestMethod.GET)
	public ResponseEntity<List<CovidVaccineDTO>> getAllVaccines(){
		return ResponseEntity.ok().body(vaccineService.getAllVaccines());
	}
}