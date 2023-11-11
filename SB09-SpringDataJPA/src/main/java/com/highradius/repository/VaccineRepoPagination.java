package com.highradius.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.highradius.entity.CovidVaccine;

public interface VaccineRepoPagination extends PagingAndSortingRepository<CovidVaccine, Long> {
}