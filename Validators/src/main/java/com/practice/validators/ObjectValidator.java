package com.practice.validators;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Component
public class ObjectValidator {

	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private final Validator validator = factory.getValidator();

	public <T> Set<String> validate(T objectToValidate) {
		Set<ConstraintViolation<T>> constraints = validator.validate(objectToValidate);
		if (constraints.isEmpty()) {
			return Collections.emptySet();
		}
		return constraints.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
	}
}