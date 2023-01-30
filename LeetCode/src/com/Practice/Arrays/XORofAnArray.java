package com.Practice.Arrays;

import java.util.*;

public class XORofAnArray {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 6, 7, 8 };
		System.out.println(subsetXORSum(arr));
	}

	public static int subsetXORSum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			int prev = 0;
			int count = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums.length > 2) {
					if (prev == 0) {
						prev = (nums[i] ^ nums[j]);
					} else {
						prev = prev ^ (nums[j]);
					}
					if (count > 1) {
						sum = sum + prev + (nums[i] ^ nums[j]);
					} else {
						sum = sum + (nums[i] ^ nums[j]);
					}
					count++;
				} else {
					sum = sum + (nums[i] ^ nums[j]);
				}

			}
		}
		return sum;
	}

}
