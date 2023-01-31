package com.walmart.Arrays;

public class RearrangeValues {
	
	public static void main(String[] args) {
		int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		rearrangeValuesOfAnArray(arr);
	}
	public static int[] rearrangeValuesOfAnArray(int[] arr) {
		int start = 0, end = arr.length-1;
		
		while(start <= end) {
			if(arr[start] >= 0 && arr[end] < 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;end--;
			}
			else if(arr[end] >=0) {
				end--;
			}
			else if(arr[start] < 0) {
				start++;
			}
		}
		return arr;
	}

}
