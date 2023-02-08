package com.practice.Constructors;

class Parent{
	int a, b;
	Parent(){
		a = 10;
		b = 20;
		System.out.println("Inside Parent Constructor");
	}
	Parent(int a, int b){
		this.a = a;
		this.b = b;
		System.out.println("Inside Parent parametarized Constructor");
	}
}
class Child extends Parent{
	int x, y;
	Child(){
		//super() --> if we are not using this() method then by default super() method will be called where parent constructor will get executed,
                     // so a & b values will get initialized
		x = 100;
		y = 200;
		System.out.println("Inside Child Constructor");
	}
	Child(int x, int y){
//		super(10,20); --> need to call super method explicitly to call parameterized constructor in Parent class
		this.x = x;
		this.y = y;
		System.out.println("Inside Child parametarized Constructor");
	}
	void disp() {
		System.out.println(a+" "+b+" "+x+" "+y);
	}
	
}
public class ContructorExecution {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.disp();
	}
}
//Output :- 
/*
 * Inside Parent Constructor --> these is printing because of super method call in child constructor
 * Inside Child Constructor 
 * 10 20 100 200
 */