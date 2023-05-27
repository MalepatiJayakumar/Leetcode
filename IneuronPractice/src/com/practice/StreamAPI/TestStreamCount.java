package com.practice.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStreamCount {
	public static void main(String[] args) {
		List<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		/* Get count of even number */
		System.out.println(data.stream().filter(i -> i % 2 == 0).count());
	}
}