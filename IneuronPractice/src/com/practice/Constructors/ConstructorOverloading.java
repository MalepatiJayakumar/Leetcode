package com.practice.Constructors;
class Student {

	private String name;
	private int id;
	
	Student(String name,int id){
		this("jay"); 
		// this method triggers constructor in current class , if we don't call this method then by default JVM calls super().
        // where super method executed default constructor in parent class
		
//		this("jay",10); //this() constructor call should always be present in first link of body
		this.name = name;
		this.id = id;
	}
	Student(String name){
		this();
		this.name = name;
	}
	Student(){
		id = 10;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
}
public class ConstructorOverloading {
	public static void main(String[] args) {
		Student std = new Student("dhanush" , 11);
		System.out.println("Student name :: "+std.getName());
		System.out.println("Student id :: "+std.getId());
	}

}
