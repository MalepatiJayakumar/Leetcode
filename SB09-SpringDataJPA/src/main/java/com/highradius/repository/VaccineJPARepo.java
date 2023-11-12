package com.highradius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highradius.entity.CovidVaccine;
import com.highradius.type.ResultView;

public interface VaccineJPARepo extends JpaRepository<CovidVaccine, Long> {
	/**
	 * Custom generated proxy method at runtime where using method name,
	 * findByCompanyName expects company name and generated query to search with
	 * company name dynamically.
	 */
	public Iterable<CovidVaccine> findByCompanyName(String companyName);

	/**
	 * Searchs with the country, but gets only data for which methods are provided
	 * in ResultView interface. As ResultView is an interface it generates an proxy
	 * class at runtime based on provided methods.
	 */
	public Iterable<ResultView> findByCountry(String country);
}