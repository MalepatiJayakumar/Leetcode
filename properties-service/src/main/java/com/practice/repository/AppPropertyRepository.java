package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.AppProperty;

public interface AppPropertyRepository extends JpaRepository<AppProperty, String> {
}