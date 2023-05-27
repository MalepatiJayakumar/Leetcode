package com.practice.Interfaces;

//During the child class object creation only child class object will be created but not parent class object
//(still constructor of parent is called to bring properties of parent to child)

class Parent{
	Parent(){
		System.out.println("In Parent Constructor");
		System.out.println(this.hashCode()); // prints current objects address
	}
}

class Child extends Parent{
	Child(){
		System.out.println("In Child Constructor");
		System.out.println(this.hashCode());// prints current objects address
	}
}

public class CheckOjectCreationInInheritance {
	
	public static void main(String[] args) {
		Child c= new Child();
		System.out.println(c.hashCode());// prints current objects address
	}
	
}
