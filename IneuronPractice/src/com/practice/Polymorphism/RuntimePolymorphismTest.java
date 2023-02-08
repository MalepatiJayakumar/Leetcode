package com.practice.Polymorphism;
//polymorphism
class Student {
	public void read() {
		System.out.println("read method inside Student class");
	}
	public void write() {
		System.out.println("write method inside Student class");
	}
	public void play() {
		System.out.println("play method inside Student class");
	}
}
class Engineer extends Student{
	public void read() {
		System.out.println("Practicing data science");
	}
	public void play() {
		System.out.println("Playing volleyBall");
	}
	public void test() {
		
	}
}

class Nursery extends Student{
	public void write() {
		System.out.println("writing alphabets");
	}
	public void play() {
		System.out.println("Playing Hopscotch");
	}
	
}
class Employee extends Student{
	public void play() {
		System.out.println("Playing cricket");
	}
}

class ExecuteStudent{
	//these method will accept child class arguments also(loosely coupled) --> Runtime polymorphism(code flexibility)
	public void execute(Student st) {
		st.read();
		st.write();
		st.play();
	}
}

public class RuntimePolymorphismTest {
	public static void main(String[] args) {
		Engineer en= new Engineer();
		Nursery ns= new Nursery();
		Employee em= new Employee();
		ExecuteStudent ex= new ExecuteStudent();
		ex.execute(en);
		ex.execute(ns);
		ex.execute(em);
		// passing child class objects to parent class parameter method. Here reducing number of calling methods to generic method --> polymorphism
	}
}
