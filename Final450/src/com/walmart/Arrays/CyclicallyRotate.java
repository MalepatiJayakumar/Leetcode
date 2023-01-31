package com.walmart.Arrays;
import java.util.*;
public class CyclicallyRotate {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		arr = rotateArray(arr);
		System.out.println(arr.length);
		
		List<Integer> list = new ArrayList<>();
		list.get(4);
		list.get(45);
	}
	
	public static int[] rotateArray(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {			
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return arr;
	}

}
