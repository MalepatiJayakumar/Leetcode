package com.Practice.Arrays;
import java.util.Scanner;

public class WealthiestCustomer {
	public static void main(String[] args) {
		
		int[][] arr = {{1,5},{7,3},{3,5}};
		int m = arr.length, n = arr[0].length;
		int output = 0 , sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum = 0;
			for(int j=0;j<arr[i].length;j++) {
				sum = sum + arr[i][j];
			}
			if(output < sum ) {
				output = sum;
			}
		}
		System.out.println(output);
	}

}
