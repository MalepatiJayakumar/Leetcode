package com.Practice.Arrays;

public class GreatestNumberOfCandies {
	public static void main(String[] args) {
		int[] arr = {2,3,5,1,3};
		int extraCandies = 3 , max = 0;
		for(int i=0;i<arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		boolean[] ans = new boolean[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(max <= arr[i]+3) {
				ans[i] = true;
			}
			else {
				ans[i] = false;
			}
		}
		for(boolean b:ans) {
			System.out.println(b);
		}
	}

}
