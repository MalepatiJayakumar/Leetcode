package com.practice.Abstract;

abstract class Loan {
	
	public Loan() {
		//abstract class can have constructor
		//But abstract constructor can't be created
	}
	
	// class should be abstract if there is one or more abstract methods in a class
	abstract public void intrest();// abstract methods doesn't have any body/implementation

	//abstract classes can also contain concrete methods
	public void welcome() {
		System.out.println("Welcome to HDFC bank");
	}
}

class PersonalLoan extends Loan {
	// we should implement body of an method in child class if it is extending ,
	// Because we don't have any implementation so it can't call method
	public void intrest() {
		System.out.println("12% PA intrest");
	}
}

class HomeLoad extends Loan {
	public void intrest() {
		System.out.println("9% PA intrest");
	}
}

public class TestAbstract {
	public static void main(String[] args) {
//		Loan loan = new Loan(); //we can't create an object of abstract class. But we can take an reference of abstract class

		Loan pLoan = new PersonalLoan(); // polymorphism
		pLoan.welcome();
		pLoan.intrest();
	}
}
