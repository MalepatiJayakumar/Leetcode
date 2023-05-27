package com.practice.StreamAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;

public class TestFilterAndMap {
	
	public  static void main(String[] args) {
		
		List<String> names = new ArrayList<>(Arrays.asList("sachin","saurav","dhoni","yuvi"));
		
		/* Predicate(I) --> public abstract boolean test(T) */
		System.out.println(names.stream().filter(name->name.length()>5).collect(Collectors.toList()));
		
		/* Function(I) --> public abstract <R> apply(T) */
		System.out.println(names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList()));
	}
	
}
