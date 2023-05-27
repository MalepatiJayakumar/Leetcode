package com.practice.Annotations;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*Marker annotation-->where there is nothing inside annotation. @interface refers to annotation not interface */
@Target(ElementType.TYPE) // specifying where we can use our annotation
@Retention(RetentionPolicy.RUNTIME) // specifying till where our annotation needs to be available , here i provided
									// till runtime which means till JVM
@interface CricketPlayer {
}

@CricketPlayer
class Dhoni {
	void player() {
		System.out.println("Dhoni is an cool captain");
	}
}

/*
 * Parameters annotation --> Here we will have annotation where it accepts
 * parameters.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS) //till compile time
@interface CricketPlayer1 {
	/*
	 * Approach-1
	 * parameters and providing default values in annotation itself so no need to
	 * provide at the time of annotation usage
	 */
//	String country() default "India";
//	int runs() default 20000;
	
	/*
	 * Approach - 2 
	 * Just declared parameters in annotation but not provided any
	 * values so we should provide values at the time of annotation usage otherwise
	 * it would result in compile time error
	 */
	String country();
	int runs();
}


@CricketPlayer1(country = "India", runs = 10000) // if we have provided default values in CricketPlayer1 annotation then we don't need to provide from here
class Rohit {
	void player() {
		System.out.println("Rohit is an Very good player");
	}
}

public class CustomAnnotations {
	public static void main(String[] args) {
		Dhoni d= new Dhoni();
		d.player();
		
		Rohit r= new Rohit();
		r.player();
	}
}
