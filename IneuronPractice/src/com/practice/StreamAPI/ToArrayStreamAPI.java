package com.practice.StreamAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ToArrayStreamAPI {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(10,5,20,15,30,25));
		
		/* converting list to Array using normal method */
		Integer[] arr = new Integer[list.size()];
		for(int i=0;i<list.size();i++)
		{
			arr[i] = list.get(i);
		}
		for(Integer i : arr) {			
			System.out.println(i);
		}
		
		System.out.println();
		
		
		/* converting list to Array using stream API */
		Object[] arr1 = list.stream().toArray();
		for(Object obj : arr1)
			System.out.println(obj);
		
		/* converting list to Array using Stream API & constructor reference */
		Integer[] arr2 = list.stream().toArray(Integer[]::new);
		for(Integer i : arr2)
			System.out.println(i);
	}
	
}
