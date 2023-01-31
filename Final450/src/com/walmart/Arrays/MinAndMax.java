package com.walmart.Arrays;

public class MinAndMax {
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 1, 9};
		minMax(arr);
	}
	public static void minMax(int[] arr) {
		int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
		int i=0,j=arr.length-1;
		while(i<=j) {
			if(arr[i] < arr[j] && min > arr[i]) {
				min = arr[i];
			}
			else if(arr[j] <= arr[i] && min> arr[j] ) {
			    min = arr[j];
			}
			
			if(arr[i] > arr[j] && max < arr[i]) {
				max = arr[i];
			}
			else if(arr[j] >= arr[i] && max < arr[j]) {
				max = arr[j];
			}
			i++;j--;
		}
		System.out.println("Minimum "+min);
		System.out.println("Maximum "+max);
	}

}
