package com.highradius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highradius.dto.JobApplicationDTO;
import com.highradius.service.JobApplicationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/application")
public class JobApplicationController {

	@Autowired
	private JobApplicationService jobApplicationService;

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@ApiOperation(value = "Apply for Job", notes = "provide details of an job Applicant", response = String.class)
	public ResponseEntity<String> applyForJob(@RequestBody JobApplicationDTO jobApplicationDTO) {
		return new ResponseEntity<>(jobApplicationService.applyForJob(jobApplicationDTO), HttpStatus.OK);
	}
}