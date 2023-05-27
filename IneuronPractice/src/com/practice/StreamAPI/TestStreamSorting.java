package com.practice.StreamAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestStreamSorting {

	public static void main(String[] args) {
		List<Integer> data = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));

		/*
		 * sorting using default natural sorting order(comparable) , where ArrayList
		 * extends comparable so it will call internally >> converts like
		 * data.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList())
		 */
		System.out.println(data.stream().sorted().collect(Collectors.toList()));
		
		
		
		List<Integer> data1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		/* customized sorting */
		System.out.println(data1.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList()));

	}

}
