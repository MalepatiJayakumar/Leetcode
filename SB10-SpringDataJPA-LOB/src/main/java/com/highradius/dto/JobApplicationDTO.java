package com.highradius.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationDTO {
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String degree;
	@NonNull
	private String photoPath;
	@NonNull
	private String resumePath;
	
	private String status;
}