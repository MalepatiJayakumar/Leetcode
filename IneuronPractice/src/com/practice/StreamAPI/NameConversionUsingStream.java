package com.practice.StreamAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;

public class NameConversionUsingStream {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>(Arrays.asList("jai","kumar","reddy"));
		
		/* converting names to upperCase till JDK 1.7v */
		List<String> names1 = new ArrayList<>();
		for(String name : names) {
			names1.add(name.toUpperCase());
		}
		
		System.out.println(names1);
		
		/* Converting names to upperCase from JDK 1.8v */
		System.out.println(names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList()));
	}
}
