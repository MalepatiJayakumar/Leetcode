package com.practice.Interfaces;

interface Jai {
	void teaches();

	void work();

	// we can give method implementation in interface only with default keyword,
	// introduced from java 8. These method will be inherited to all the
	// implementation methods.
	default void village() {
		System.out.println("Jai kumar belongs to sathyavedu");
	}
	
	// we can have static methods in interface but static methods won't participate
	// in inheritance/Override , so we should access static methods using interface
	// names only
	static void school() {
		System.out.println("Jai kumar studied in Masters High School");
	}
	
	
	//Below two private methods can be possible from Java 9  only
//	private void college() {
//		System.out.println("jai kumar studied in chaithanya college");
//	}
	
//	private static void university() {
//		System.out.println("jai kumar studied in chandigarh university");
//	}
}

class Student implements Jai {

	@Override
	public void teaches() {
		System.out.println("Jai kumar teaches java");
	}

	@Override
	public void work() {
		System.out.println("Jai kumar works for HighRadius corporation");
	}
	
	//we can also override methods in implementation class.
//	@Override
//	public void village() {
//		System.out.println("Overrided method in implementation class");
//	}

}

public class MethodDeclarationInInterface {
	public static void main(String[] args) {
		Student std= new Student();
		std.teaches();
		std.work();
		std.village(); // we are not overriding in implementation class so we will get method in interface
		
		Jai.school(); //Accessing static methods in interface
	}
}
