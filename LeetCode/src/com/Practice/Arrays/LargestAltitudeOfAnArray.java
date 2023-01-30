package com.Practice.Arrays;

public class LargestAltitudeOfAnArray {

	public static void main(String[] args) {
		int[] gain = {-5,1,5,0,-7};
		largestAltitude(gain);
	}
	public static int largestAltitude(int[] gain) {
        int max = 0;  
        int sum = 0;
        for(int i=0;i<gain.length;i++){
            sum = sum + gain[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
