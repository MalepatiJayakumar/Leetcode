package com.highradius.generator;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class IDGenerator {
	public static String generateId() {
		return UUID.randomUUID().toString().substring(0, 15);
	}
}