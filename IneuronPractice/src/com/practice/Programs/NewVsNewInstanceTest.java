package com.practice.Programs;
import com.practice.Programs.Student;
class Student{
	
	static {
		System.out.println("Inside Static block of student class");
	}
	
	Student(){
		System.out.println("Inside Student constructor");
	}
	
	{
		System.out.println("Inside instance block of student class");
	}
}

public class NewVsNewInstanceTest {
	
	//Passing className as argument from command line
	public static void main(String[] args) throws Exception {
	
		System.out.println("Executing new keyword object creation");
		// Creating an object using new keyword
		Student std1= new Student();
		System.out.println(std1);
		System.out.println();
		System.out.println();
		System.out.println("Executing object creation using newInstance()");
		@SuppressWarnings("rawtypes")
		Class c= Class.forName(args[0]);
		System.out.println(c);
		Object obj= c.newInstance();
		System.out.println(obj.getClass().getName());
	}

}

