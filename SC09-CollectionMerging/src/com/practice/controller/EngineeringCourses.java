package com.practice.controller;

import java.util.Set;

public class EngineeringCourses {
	private Set<String> subjects;

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "EngineeringCourses [subjects=" + subjects + "]";
	}
}