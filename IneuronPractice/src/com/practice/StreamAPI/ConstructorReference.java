package com.practice.StreamAPI;

class Sample {
	private String s;
	Sample(String s){
		this.s = s;
		System.out.println("Contrustor executed "+s);
	}
}

@FunctionalInterface
interface Interf {
	public Sample m1(String s);
}

public class ConstructorReference {
	public static void main(String[] args) {
		/* Using lambda Expression */
		Interf i = s -> new Sample(s); //binding Sample object to Interf
		i.m1("from lambda expression");
		System.out.println();
		
		/* Using constructor Reference */
		Interf i1 = Sample::new;
		i1.m1("from Constructor reference");
		
	}
}
