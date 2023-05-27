package com.practice.Revision;

class Student {
	Integer rollNumber;
	String name;
	String city;
}

public class CustomArray {
	public static void main(String[] args) {
		
		Student[] std= new Student[3];
		std[0]= new Student();
		std[0].rollNumber=1;
		std[0].name="Jai";
		std[0].city= "Hyderabad";
		
		std[1]= new Student();
		std[1].rollNumber=2;
		std[1].name="dhanush";
		std[1].city= "Chittoor";
		
		std[2]= new Student();
		std[2].rollNumber=3;
		std[2].name="Mahesh";
		std[2].city= "Chennai";
		
		System.out.println("ClassName of an array :: "+std[0].getClass().getName());
		System.out.println("size of an array :: "+std.length); // length is an instance variable so we are accessing directly
	}
}
