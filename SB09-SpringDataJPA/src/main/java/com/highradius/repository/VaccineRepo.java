package com.highradius.repository;

import org.springframework.data.repository.CrudRepository;

import com.highradius.entity.CovidVaccine;

public interface VaccineRepo extends CrudRepository<CovidVaccine,Long> {
}