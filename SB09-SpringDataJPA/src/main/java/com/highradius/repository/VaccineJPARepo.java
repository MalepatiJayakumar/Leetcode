package com.highradius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highradius.entity.CovidVaccine;

public interface VaccineJPARepo extends JpaRepository<CovidVaccine, Long> {
}