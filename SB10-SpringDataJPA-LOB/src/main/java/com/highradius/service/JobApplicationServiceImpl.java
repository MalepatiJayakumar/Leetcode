package com.highradius.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highradius.dto.JobApplicationDTO;
import com.highradius.entity.JobApplication;
import com.highradius.persistence.JobApplicationDAO;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	private static Logger logger = LoggerFactory.getLogger(JobApplicationServiceImpl.class);
	
	@Autowired
	private JobApplicationDAO jobApplicationDAO;
	
	@Override
	public String applyForJob(JobApplicationDTO jobApplicationDTO) {
		try {
			byte[] photo = null;
			char[] resume = null;
			File file = new File(jobApplicationDTO.getResumePath());
			try (InputStream inputStream = new FileInputStream(jobApplicationDTO.getPhotoPath());
					FileReader reader = new FileReader(file);) {
				photo = new byte[inputStream.available()];
				inputStream.read(photo);
				resume = new char[(int) file.length()];
				reader.read(resume);
			}
			JobApplication application = new JobApplication();
			BeanUtils.copyProperties(jobApplicationDTO, application);
			application.setPhoto(photo);
			application.setResume(resume);
			application.setStatus("Submitted");
			jobApplicationDAO.save(application);
			return application.getName() + " application has been submitted successfully.";
		} catch (Exception e) {
			logger.error("Exception occurred while saving the job application ",e);
		}
		return jobApplicationDTO.getName() + " application has been submitted failed, please try again";
	}

	@Override
	public String getApplicationStatus(Long id) {
		return null;
	}
}