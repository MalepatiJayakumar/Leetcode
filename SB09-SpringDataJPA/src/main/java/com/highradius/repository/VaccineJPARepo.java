package com.highradius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highradius.entity.CovidVaccine;

public interface VaccineJPARepo extends JpaRepository<CovidVaccine, Long> {
	/**
	 * Custom generated proxy method at runtime where using method name,
	 * findByCompanyName expects company name and generated query to search with
	 * company name dynamically.
	 */
	public Iterable<CovidVaccine> findByCompanyName(String companyName);
}