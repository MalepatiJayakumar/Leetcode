package com.practice.entity;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="todo")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@Nonnull
	private String title;
	
	@Nonnull
	@Column(name="due_date")
	private Date dueDate;
	
	@Nonnull
	private boolean isCompleted;

}
