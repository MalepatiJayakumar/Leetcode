package com.practice.serviceImpl;

import com.practice.service.Course;

public class ReactCourse implements Course {

	public ReactCourse() {
		System.out.println("ReactCourse object has been instantiated");
	}
	
	public boolean selectCourse() {
		System.out.println("You already purchased react course.");
		return true;
	}

}
