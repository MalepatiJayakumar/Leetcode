package com.Practice.Arrays;

public class ConcatenationOfSameArray {
	public static void main(String[] args) {
		int[] nums = {1,2,1};
		System.out.println(nums.length);
		int len = nums.length * 2;
		int[] ans = new int[len];
		for(int i=0;i<len;i++) {
			if(i < nums.length) {
				ans[i] = nums[i];
			}
			else {
				int index = i - (nums.length);
				ans[i] = nums[index];
			}
		}
	}

}
