package com.practice.SystemDesign;

@FunctionalInterface
interface NewVehicle {
	public void drive();
}

class PassengerVehicle {

	void getNormalDrivingMode() {
		NewVehicle v = () -> {
			System.out.println("Normal driving");
		};
		v.drive();
	}
//	@Override
//	public void drive() {
//		System.out.println("Normal driving");
//	};
}

// one time implementation of sports mode functionality so where ever we need we can just extend & reuse the sport Mode drive method
class SportsVehicle {
	void getSportsMode() {
		NewVehicle v = () -> {
			System.out.println("sports Mode functionality");
		};
		v.drive();
	}
//	@Override
//	public void drive() {
//		System.out.println("sports Mode functionality");
//	}

}

class NewPassengerVehicle extends PassengerVehicle {

}

class NewSportMode extends SportsVehicle {

}

class NewRangeRover extends SportsVehicle {

}

public class NewVehicleUsingInteface {
	public static void main(String[] args) {
		NewPassengerVehicle n1 = new NewPassengerVehicle();
		NewSportMode n2 = new NewSportMode();
		NewRangeRover n3 = new NewRangeRover();
		n1.getNormalDrivingMode();
		n2.getSportsMode();
		n3.getSportsMode();
	}
}
