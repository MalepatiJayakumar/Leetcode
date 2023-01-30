package com.Practice.Arrays;
import java.util.Scanner;

public class BuildArrayFromPermutation {
	public static void main(String[] arr) {
		int[] nums = {0,2,1,5,3,4};
		int[] ans = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			ans[i] = nums[nums[i]];
		}
		for(int i=0;i<nums.length;i++) {
			System.out.println(ans[i]);
		}
	}

}
