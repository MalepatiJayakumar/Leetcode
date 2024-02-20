package com.practice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {

	@NotNull(message="First Name should not be null")
	@NotEmpty(message="First Name should not be empty")
	private String firstName;

	@NotNull(message="Last Name should not be null")
	@NotEmpty(message="Last Name should not be empty")
	private String lastName;

	@NotNull(message="User Name should not be null")
	@NotEmpty(message="User Name should not be empty")
	private String userName;

	@NotNull(message="Email should not be null")
	@NotEmpty(message="Email should not be empty")
	private String email;

	@NotNull(message="Phone Number should not be null")
	private Integer phoneNo;
}