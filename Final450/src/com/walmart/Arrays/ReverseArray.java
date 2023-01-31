package com.walmart.Arrays;

public class ReverseArray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		arr = reverse(arr);
		System.out.println(args.length);
		System.out.println(arr.length);
	}
	
	public static int[] reverse(int[] arr) {
		int i=0,j = arr.length-1;
		int temp;
		while(i<j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;j--;
		}
		return arr;
	}

}
