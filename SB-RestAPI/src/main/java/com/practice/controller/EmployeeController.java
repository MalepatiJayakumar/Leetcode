package com.practice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.EmployeeDTO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(value="/save/{id}" ,  method = RequestMethod.GET , produces= {"application/json"} , consumes= {"application/json"})
	//                           Path param            Query Param                       Request DTO
	public EmployeeDTO save(@PathVariable Long id , @RequestParam String name , @RequestBody EmployeeDTO emp) {
		System.out.println(emp);
		return new EmployeeDTO(name, "HRC", "HYD", 15000.00d);
	}
}