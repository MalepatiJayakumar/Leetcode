package com.highradius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	private static Logger logger = LoggerFactory.getLogger(AppController.class);

	@RequestMapping(value = "/get-name", method = RequestMethod.GET)
	public ResponseEntity<String> getName() {
		logger.info("Inside AppController method getName()");
		return new ResponseEntity<>("Jaikumar", HttpStatus.OK);
	}
}