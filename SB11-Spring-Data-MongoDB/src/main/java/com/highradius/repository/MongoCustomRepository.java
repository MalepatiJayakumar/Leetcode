package com.highradius.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.highradius.entity.Customer;

public interface MongoCustomRepository extends MongoRepository<Customer, String> {
}