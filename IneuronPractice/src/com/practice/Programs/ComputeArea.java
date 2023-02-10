package com.practice.Programs;

import java.util.Scanner;

abstract class Shape{
	//Here we are not achieving 100% abstraction
	float area;
	abstract public void input();
	abstract public void compute();
	public void display(String shape) {
		System.out.println("Area of an "+shape+" is :: " + area);
	}
}
class Square extends Shape{
	float side;

	public void input() {
		System.out.println("Please enter side of an square");
		Scanner scan = new Scanner(System.in);
		side = scan.nextFloat();
	}
	public void compute() {
		area = side * side;
	}
}

class Circle extends Shape{
	float radius;
	
	public void input() {
		System.out.println("Please enter radius of an circle");
		Scanner scan = new Scanner(System.in);
		radius = scan.nextFloat();
	}

	public void compute() {
		area = 3.14f * radius * radius;
	}
}

class Executor{
	public void executeMethods(Shape shape, String type) {
		shape.input();
		shape.compute();
		shape.display(type);
	}
}

public class ComputeArea {

	public static void main(String[] args) {
		Shape square = new Square();
		Shape circle = new Circle();
		
		Executor exe = new Executor();
		exe.executeMethods(square,"square");
		exe.executeMethods(circle,"circle");
	}

}
