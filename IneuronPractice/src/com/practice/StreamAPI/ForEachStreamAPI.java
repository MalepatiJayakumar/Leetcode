package com.practice.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachStreamAPI {
	
	public static void main(String[] args) {
		
		Stream<Double> s = Stream.of(1.1,1.2,1.3,1.4,1.5,1.6);
		s.forEach(System.out::println);
		
		/* ______________OR_____________ */
		
		System.out.println();
		Double[] d = {1.1,1.2,1.3,1.4,1.5,1.6};
		Stream<Double> s1 = Stream.of(d);
		s1.forEach(System.out::println);
		
		
		
		List<String> names = new ArrayList<>(Arrays.asList("jai","kumar","reddy","dhanush","mahesh"));
		names.stream().forEach(ForEachStreamAPI::executeTestMethod);
	}
	
	public static String executeTestMethod(String name) {
		System.out.println(name);
		return name;
	}

}
