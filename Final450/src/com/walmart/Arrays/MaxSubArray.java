package com.walmart.Arrays;

public class MaxSubArray {
	
	public static void main(String[] args) {
		int[] arr = {-1,-2,-3,-4};
		int max = Integer.MIN_VALUE , sum = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max ) {
				max = arr[i];
			}
			sum  = sum + arr[i];
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}

}
