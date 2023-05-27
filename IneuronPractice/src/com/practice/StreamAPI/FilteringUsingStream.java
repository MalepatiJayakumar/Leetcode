package com.practice.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringUsingStream {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		
		/*Getting even numbers using normal loop*/
		List<Integer> filterData1 = new ArrayList<>();
		for (Integer i : list) {
			if (i % 2 == 0) {
				filterData1.add(i);
			}
		}
 		System.out.println(filterData1);
 		
		/* Getting even numbers using stream API filter */
 		List<Integer> filterData2 = new ArrayList<>();
 		filterData2 = list.stream().filter(i-> i%2==0).collect(Collectors.toList());
// 		System.out.println(filterData2);
 		filterData2.forEach(System.out :: println);
	}

}
