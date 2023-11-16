package com.highradius.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.highradius.entity.JobApplication;

public interface JobApplicationDAO extends PagingAndSortingRepository<JobApplication, Long> {

}