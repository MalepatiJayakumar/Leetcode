package com.Practice.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int Selement = 9;
		int result = search(arr, 0, arr.length - 1, Selement);
		System.out.println(result);
	}

	public static int search(int[] arr , int s , int n , int searchValue) {
		if(s <= n) {
		int mid = (s + n)/2;
		if(arr[mid] == searchValue) {
			return mid;
		}
		else {
			if(arr[mid] > searchValue) {
				n = mid-1;
				return search(arr,s,n,searchValue);
			}
			else {
				s = mid + 1;
				return search(arr,s,n,searchValue);
			}
			
		}
		}
		return -1;
	}

}
