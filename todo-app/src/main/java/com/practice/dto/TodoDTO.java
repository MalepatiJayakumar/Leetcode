package com.practice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDTO {
	
	private Integer id;
	
	private String title;
	
	private Date dueDate;
	
	private boolean isCompleted;

}
