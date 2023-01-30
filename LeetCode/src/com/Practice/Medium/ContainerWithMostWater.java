package com.Practice.Medium;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int area = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                if(height[i] > height[j] && height[j]*height[j]>area && j-i ==height[j]){
                    area = height[j]*height[j];
                }
                else {
                    if(height[i]*height[i] > area && j-i ==height[i]){
                        area = height[i] * height[i];
                    }
                }
            }
        }
        return area;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}

}
