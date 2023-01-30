package com.Practice.Arrays;

import java.util.HashMap;

public class SmallerThanCurrentNumber {
	public static void main(String[] args) {
		int[] arr = { 8, 1, 2, 2, 3 };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			if (!map.containsKey(arr[i])) {
				for (int j = 0; j < arr.length; j++) {
					if (i != j) {
						if (arr[i] > arr[j]) {
							count++;
						}
					}
				}
				map.put(arr[i], count);
			}
		}
		int[] ans = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			ans[i] = map.get(arr[i]);
		}

	}
}
