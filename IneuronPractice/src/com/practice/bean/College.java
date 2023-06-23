package com.practice.bean;

import java.io.Serializable;

public class College implements Serializable {
	private static final long serialVersionUID = 1L;
	String collegeName = "Chandigarh University";
	String city = "chandigarh";
	String state = "punjab";
	
	@Override
	public String toString() {
		return "College [collegeName=" + collegeName + ", city=" + city + ", state=" + state + "]";
	}
}
