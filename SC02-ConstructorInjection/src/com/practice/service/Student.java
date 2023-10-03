package com.practice.service;

public class Student {
	
	private Integer id;
	private String name;
	private String college;
	private Float percentage;
	
	public Student(Integer id, String name, String college, Float percentage) {
		this.id = id;
		this.name = name;
		this.college = college;
		this.percentage = percentage;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", percentage=" + percentage + "]";
	}
}