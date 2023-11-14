package com.highradius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.service.VaccineService;
import com.highradius.type.ResultView1;
import com.highradius.type.View;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	/**
	 * For Pagination we can use Pageable object in same PagingAndSortingRepository Object
	 */
	
	@Autowired
	private VaccineService vaccineService;

	@RequestMapping(value = "/add-vaccine", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCovidVaccineProvider(@RequestBody CovidVaccineDTO vaccine) {
		vaccineService.saveCovidVaccineProvider(vaccine);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/get-all-vaccines", method = RequestMethod.GET)
	public ResponseEntity<List<CovidVaccineDTO>> getAllVaccines() {
		return ResponseEntity.ok().body(vaccineService.getAllVaccines());
	}

	@RequestMapping(value = "/total-count", method = RequestMethod.GET)
	public ResponseEntity<Long> getVaccineCount() {
		return ResponseEntity.ok().body(vaccineService.getVaccineCount());
	}

	@RequestMapping(value = "/get-on-sorted-order/{order}", method = RequestMethod.POST)
	public ResponseEntity<List<CovidVaccineDTO>> getVaccinesOnSortedOrder(@PathVariable String order,@RequestBody List<String> properties) {
		return ResponseEntity.ok().body(vaccineService.getVaccinesOnSortedOrder(order, properties));
	}
	
	@RequestMapping(value="/get-vaccines-for-a-company/{companyName}",method=RequestMethod.GET)
	public ResponseEntity<List<CovidVaccineDTO>> getVaccinesForACompany(@PathVariable String companyName){
		return ResponseEntity.ok().body(vaccineService.getVaccinesForACompany(companyName));	
	}
	
	@RequestMapping(value="/get-vaccines-for-a-country/{country}",method=RequestMethod.GET)
	public ResponseEntity<Iterable<ResultView1>> getRequestData(@PathVariable String country){
		return ResponseEntity.ok().body(vaccineService.getRequestData(country));
	}
	
	/*
	@RequestMapping(value="/get-based-on-price/{price}/{className}", method=RequestMethod.GET)
	public ResponseEntity<Iterable<View>> getVaccinesOnPrice(@PathVariable Double price,String className){
		return ResponseEntity.ok().body(vaccineService.getVaccinesOnPrice(price,className));
	}
	*/
}