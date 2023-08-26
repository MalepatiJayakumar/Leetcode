package com.Practice.DSA;

import java.util.*;

public class MinimumIterations {
	static int count = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int n = 1;     
		System.out.println(solution(arr, n));

		count = 0;

		int[] arr1 = { 5, 4, 3, 2, 1 };
		int n1 = 5;
		System.out.println(solution(arr1, n1));

		count = 0;

		int[] arr2 = { 0, 0, 0, 0, 0 };
		int n2 = 0;
		System.out.println(solution(arr2, n2));

		count = 0;

		int[] arr3 = { 3, 2, 5, 23, 2, 4 };
		int n3 = 3;
		System.out.println(solution(arr3, n3));

		count = 0;
	}

	public static int solution(int[] arr, int n) {
		count++;
		List<Integer> tempList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				continue;
			}
			if (arr[i] <= n) {
				tempList.add(arr[i]);
			}
		}
		if (tempList.size() > 0) {
			int[] tempArr = new int[tempList.size()];
			for (int i = 0; i < tempList.size(); i++) {
				tempArr[i] = tempList.get(i);
			}
			return solution(tempArr, tempList.get(0));
		}
		return count;
	}
}
