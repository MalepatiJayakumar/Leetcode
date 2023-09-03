package com.practice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDateTime dob;
	private LocalDate doj;
	private LocalTime currentTime;
	
	public PersonInfo() {
		System.out.println("Zero args constructor in PersonInfo");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalTime getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(LocalTime currentTime) {
		this.currentTime = currentTime;
	}
	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", currentTime="
				+ currentTime + "]";
	}
	
}
