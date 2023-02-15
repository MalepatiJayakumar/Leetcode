package com.practice.InnerClass;

import com.practice.InnerClass.Computer.Hardware;
import com.practice.InnerClass.Computer.Software;

class Computer {
	
	public void compute() {
		System.out.println("Inside compute method");
	}
	
	class Hardware{
		public void memory() {
			System.out.println("Inside hardware class --> memory method");
		}
	}
	
	static class Software{
		public void eclipse() {
			System.out.println("Eclipse has been installed");
		}
	}
	
}

public class InnerClass1 {
	public static void main(String[] args) {
		
		Computer com= new Computer();
		com.compute();

		//Need parent class reference object to create child class object
		Hardware hard= com.new Hardware();
		hard.memory();
		
		//static inner class can be accessed using parent class.
		Software soft= new Computer.Software(); 
		soft.eclipse();
		
		//anonymous inner class implementation
		Computer com1= new Computer() {
			public void compute() {                //These method overrides super class compute method
				System.out.println("Inside anonymous inner class");
			}
		};
		com1.compute();
	}
}
