package com.practice.serviceImpl;

import com.practice.service.Course;

public class PythonCourse implements Course {

	public PythonCourse() {
		System.out.println("PythonCourse object has been instantiated");
	}
	
	public boolean selectCourse() {
		System.out.println("Sorry , python course is not in your courses . Please purchase for continuing learning");
		return false;
	}

}
