package com.Practice.Arrays;
import java.util.List;
import java.util.ArrayList;
public class MaxPairsPossible {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 2, 2 };
		numberOfPairs(nums);
	}

	public static int[] numberOfPairs(int[] nums) {
		int pairs = 0;
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			flag = false;
			if (nums[i] == Integer.MAX_VALUE) {
				flag = true;
			}
			if (!flag) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] == nums[j]) {
						nums[i] = Integer.MAX_VALUE;
						nums[j] = Integer.MAX_VALUE;
						pairs++;
						break;
					}
				}
			}

		}
		int rem = nums.length - (pairs * 2);
		int[] output = { pairs, rem };
		List<String> list1= new ArrayList<>();
		List<String> list2= new ArrayList<>();
		list.containsAll(list2);
		return output;
	}

}
