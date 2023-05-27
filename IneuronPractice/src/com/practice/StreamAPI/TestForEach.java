package com.practice.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestForEach {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>(Arrays.asList("sachin", "dhoni", "kohli", "rohit"));
		/*
		 * As consumer is an functional interface we can use lambda expression to print
		 * names in list as below
		 */
		System.out.println("Printing names using consumer lambda expressions");
		list.forEach(name -> System.out.println(name));

		System.out.println();

		/* printing names using method reference */
		System.out.println("Printing names using method reference");
		list.forEach(System.out::println); // backend --> name->sysout(name)

	}
}
