package com.practice.controller;

public class AlphaNumericGenerator {
	public static void main(String[] args) {
		/*
		 * When starting at '000' => We hit 'zzz' (i.e. Dead End) at 46,656 When
		 * starting at 'A00' => We hit 'zzz' (i.e. Dead End) at 33,696
		 */

		int index = 0;
		String currentNumber = "000";
		while (index < 46656) {
			index++;

			String incrementedNumber = base36Incrementer(currentNumber, 36);
			currentNumber = incrementedNumber;

			if (incrementedNumber.toCharArray().length != 3) {
				System.out.println("We got intruder with length: " + incrementedNumber.toCharArray().length);
				System.out.println("Our Intruder is: " + incrementedNumber);
				break;
			}

			System.out.println(incrementedNumber);
		}
		System.out.println("Number of entries: " + index);
	}

	// The function that increments current string
	public static String base36Incrementer(String v, int targetBase) {
		String answer = Integer.toString(Integer.parseInt(v, targetBase) + 1, targetBase);

		return String.format("%3s", answer).replace(' ', '0');
	}
}