package com.practice.controller;

import com.practice.service.Course;

public class SelectCourse {
	
	private Course course;
	
	public SelectCourse(Course course) {
		this.course = course;
	}
	
	public void selectCourse() {
		course.selectCourse();
	}
	
}
