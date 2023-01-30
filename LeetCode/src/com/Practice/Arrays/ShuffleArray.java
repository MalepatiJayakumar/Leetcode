package com.Practice.Arrays;

public class ShuffleArray {
	public static void main(String[] args) {
		int[] arr = {2,5,1,3,4,7};
	    int[] ans = new int[arr.length];
  		if(arr.length % 2 == 0) {
			ans = calculateArray(arr);	
		}
  		else {
  			ans =  calculateArray(arr);
			ans[arr.length-1] = arr[arr.length-1];
  		}
		for(int a:ans) {
			System.out.print(a+" ");
		}
		
	}
	public static int[] calculateArray(int[] arr) {
		int size = arr.length / 2;
		int index = 0;
		int[] ans = new int[arr.length];
		for(int i=0;i<size;i=i+1) {
			ans[index] = arr[i];
			ans[index + 1] = arr[size+i];
			index += 2;
		}
		return ans;
	}

}
