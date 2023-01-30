package com.Practice.Arrays;

public class RunningSumOfAnArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] ans = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			if(i==0) {
				ans[i] = nums[i];
			}
			else {
				ans[i] = nums[i] + ans[i-1];
			}
		}
	}

}
