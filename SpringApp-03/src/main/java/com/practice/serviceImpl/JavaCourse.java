package com.practice.serviceImpl;

import com.practice.service.Course;

public class JavaCourse implements Course {

	public JavaCourse() {
		System.out.println("JavaCourse object has been instantiated");
	}
	
	public boolean selectCourse() {
		System.out.println("Java course is in your bucket please completed asap");
		return true;
	}

}
