package com.practice.Annotations;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Corporate {
	/*
	 * Here i am providing values in annotation itself so i don't need to pass when
	 * i am using annotation
	 */
	String name() default "HRC";
	String city() default "HYD";
}

@Corporate
class HighRadius {
	
}

public class AccessValuesFromCustomAnnotation {
	
	public static void main(String[] args) {
		HighRadius hrc= new HighRadius();
		Class c= hrc.getClass(); // getting class
		/*
		 * getting annotation using getAnnotation method from class to Annotation and
		 * downcasting to Corporate annotation type
		 */
		Annotation a= c.getAnnotation(Corporate.class);  
		Corporate cor= (Corporate)a;
		System.out.println("Name of company :: "+cor.name());
		System.out.println("company located in :: "+cor.city());
	}
	
}
