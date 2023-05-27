package com.practice.Abstract;

/*As we don't want to give direct access to Person class to anyone we should declare it as abstract
Because person doesn't exist in real-time, only types of persons exists like student,employee...
*/abstract class Person{
	
	/*
	 * So we can declare variables, constructor and also instance block in
	 * abstract class
	 */	
	String name;
	Integer age;
	Float height;
	
	/* purpose of constructor here is for initialization of instance variables */
	Person(String name, Integer age, Float height){
		this.name= name;
		this.age= age;
		this.height= height;
	}
}

class Student extends Person{
	
	String courseName;
	Float marks;
	
	Student(String name, Integer age, Float height, String courseName, Float marks){
		super(name, age, height);
		this.courseName= courseName;
		this.marks= marks;
	}
}

public class AbstractClassConstructor {
	public static void main(String[] args) {
		
		Student std= new Student("Jai",21,5.10f,"ReactJs",95f);
	}
}
