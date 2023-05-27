package com.practice.Interfaces;

class Animal {
	public String noise() {
		return "peep";
	}
}

class Dog extends Animal {
	public String noise() {
		return "bark";
	}
}

class Cat extends Animal {
	public String noise() {
		return "meow";
	}
}

public class CheckExtends {
	public static void main(String[] args) {
		
		Animal animal= new Dog();
		Cat cat= (Cat)animal; //Exception in thread "main" java.lang.ClassCastException: com.practice.Interfaces.Dog cannot be cast to com.practice.Interfaces.Cat
							 //		at com.practice.Interfaces.CheckExtends.main(CheckExtends.java:25)

		System.out.println(cat.noise());
		
	}
}
