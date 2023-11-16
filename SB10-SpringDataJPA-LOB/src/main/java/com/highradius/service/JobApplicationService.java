package com.highradius.service;

import com.highradius.dto.JobApplicationDTO;

public interface JobApplicationService {
	
	public String applyForJob(JobApplicationDTO jobApplicationDTO);
	public String getApplicationStatus(Long id);
}