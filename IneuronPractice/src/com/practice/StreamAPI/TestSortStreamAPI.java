package com.practice.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestSortStreamAPI {

	public static void main(String[] args){
		List<Integer> list = new ArrayList<>(Arrays.asList(10,20,0,5,25,15));

	 	/*default natural sorting using sorted method in Stream API*/
	 	List<Integer> list1 = list.stream().sorted().collect(Collectors.toList());
	 	System.out.println(list1);

	 	/*customized sorting using comparator (descending order sorting) in Stream API*/
	 	List<Integer> list2 = list.stream().sorted((i1,i2) -> i2.compareTo(i1)).collect(Collectors.toList());
	 	System.out.println(list2);
	}	
	
}
