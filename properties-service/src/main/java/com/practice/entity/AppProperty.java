package com.practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_properties")
@Setter
@Getter
public class AppProperty {
	@Id
	@Column(name = "property_key")
	private String key;

	@Column(name = "property_value")
	private String value;
}
