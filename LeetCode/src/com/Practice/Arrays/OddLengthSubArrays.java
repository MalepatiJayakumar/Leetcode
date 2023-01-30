package com.Practice.Arrays;

public class OddLengthSubArrays {
	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		int output = sumOddLengthSubarrays(arr);
		System.out.println(output);
	}
	public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0 , maxIndex = 1;
        for(int i=0;i<arr.length;i++){
            int incr = 1;
            while(i+incr <= arr.length) {
            	for(int j =i;j<(i+incr);j++) {
            		sum = sum + arr[j]; 
            	}
            	incr = incr + 2;
            }
        }
        return sum;
    }

}
