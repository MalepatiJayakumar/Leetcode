package com.practice.SystemDesign;

class Vehicle{
	public void drive() {
		System.out.println("Normal driving");
	}
}

class OldPassangersVehicle extends Vehicle{
	
}

// Both OldSportsVehicle & RangeRover has same functionality (same body) still we need to write twice because of parent is not supporting sports mode functionality
class OldSportsVehicle extends Vehicle {
	
	public void drive() {
		System.out.println("sports Mode functionality");
	}
	
}

class RangeRover extends Vehicle {
	public void drive() {
		System.out.println("sports Mode functionality");
	}
}

public class OldVehicle {
	public static void main(String[] args) {
		RangeRover r= new RangeRover();
		OldSportsVehicle o= new OldSportsVehicle();
		OldPassangersVehicle o1= new OldPassangersVehicle();
		r.drive();
		o.drive();
		o1.drive();
		
		
	}
}
