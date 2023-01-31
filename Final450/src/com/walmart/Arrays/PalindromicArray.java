package com.walmart.Arrays;

public class PalindromicArray {
	
	public static void main(String[] args) {
		int[] arr = {111,222,333,444,555,123};
		System.out.println(checkPalindromicArray(arr));
	}

	private static int checkPalindromicArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int val = arr[i];
			int rev = 0;
			while(val>0) {
				int temp = val % 10;
				rev = rev * 10 + temp;
				val = val / 10;
			}
			if(!(rev == arr[i])) {
				return 0;
			}
		}
		return 1;
	}

}
