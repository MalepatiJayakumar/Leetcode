package com.practice.controller;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.PersonDTO;
import com.practice.validators.ObjectValidator;

@RestController
public class PersonController {

	@Autowired
	ObjectValidator validator;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> validate(@RequestBody PersonDTO personDTO) {
		Set<String> validations = validator.validate(personDTO);
		if (validations.isEmpty()) {
			return new ResponseEntity<String>("validation success", HttpStatus.OK);
		}
		return new ResponseEntity<String>(validations.stream().collect(Collectors.joining("\n")),
				HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PersonDTO> test() {
		return new ResponseEntity<PersonDTO>(new PersonDTO(LocalDate.now()), HttpStatus.OK);
	}
}