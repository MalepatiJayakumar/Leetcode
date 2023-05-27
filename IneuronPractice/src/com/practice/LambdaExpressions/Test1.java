package com.practice.LambdaExpressions;

//functional interface --> interface with single abstract method
//@FunctionalInterface is an annotation that indicates these interface as functional interface to JVM
@FunctionalInterface
interface Demo{
	
	// By default all the methods inside an interface is public and abstract
	void display(int a);
}

public class Test1 {

	public static void main(String[] args) {
		// interface should have only one method that needs to be abstract to use lambda
		// expression
		// -> is an representation of lambda expression
		// left side of lambda expression is arguments that are required for that method
		// in interface
		// Right side of lambda expression is body of that method
		// these method is also known as anonymous methods
		Demo d = (a) -> {
			System.out.println("Value provided is :: " + a);
			System.out.println("Lambda expression test");
		};
		d.display(10);
	}

}
