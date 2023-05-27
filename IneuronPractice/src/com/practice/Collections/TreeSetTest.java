package com.practice.Collections;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet ts= new TreeSet();
		ts.add(25);
		ts.add(50);
		ts.add(75);
		ts.add(100);
		ts.add(125);
		ts.add(150);
		ts.add(175);
		System.out.println(ts);
			
		System.out.println(ts.ceiling(50));// finds same object if it is not found returns next highest number, if not found returns null
		System.out.println(ts.floor(50));// finds same object if it is not found returns next lowest number, if not found returns null
		System.out.println(ts.higher(50)); // returns next higher object , if not found returns null
		System.out.println(ts.lower(50)); // returns next lower object, if not found returns null
		
		System.out.println("******************************");
		
		System.out.println(ts.ceiling(40));// finds same object if it is not found returns next highest number, if not found returns null
		System.out.println(ts.floor(40));// finds same object if it is not found returns next lowest number, if not found returns null
		System.out.println(ts.higher(40)); // returns next higher object , if not found returns null
		System.out.println(ts.lower(40)); // returns next lower object, if not found returns null
	}
}
