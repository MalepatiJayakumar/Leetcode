package com.practice.Programs;

public class LabelledBlockCheck {

	public static void main(String[] args) {

		l1: for (int i = 0; i < 5; i++) {
			l2: for (int j = 0; j < 5; j++) {
				l3: for (int k = 0; k < 5; k++) {
					System.out.println("IN Block 1");
					break l2;
				}
				System.out.println("IN Block 2");
			}
			System.out.println("IN Block 3");
		}
	}
}