package com.Practice.Arrays;
import java.util.*;

public class CountGoodTriplets {
	public static void main(String[] args) {
		int[] arr = {3,0,1,1,9,7};
		int a = 7, b = 2, c = 3;
		System.out.println(countGoodTriplets(arr,a,b,c));
	}
	 public static int countGoodTriplets(int[] arr, int a, int b, int c) {
	        List<List<Integer>> list = new ArrayList<>();
	        List<Integer> subList = new ArrayList<>();
	        for(int i=0;i<arr.length;i++){
	            for(int j=i+1;j<arr.length-1;j++){
	            	for(int k=j+1;k<arr.length;k++) {
	                subList = new ArrayList<>();
	                if((Math.abs(arr[i]-arr[j]))<=a && (Math.abs(arr[j]-arr[k]))<=b && (Math.abs(arr[i]-arr[k]))<=c){
	                    subList.add(a);
	                    subList.add(b);
	                    subList.add(c);
	                }
	                if(!subList.isEmpty()) {
	                	list.add(subList);
	                }
	            }
	            }
	        }
	        return list.size();
	    }
}
