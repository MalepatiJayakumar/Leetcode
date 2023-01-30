package com.Practice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ReturnIndex {
	public static void main(String[] args) {
		int nums[] = {2,2};
		int target = 2;
		int[] output = searchRange(nums,target);
	}
	 public static int[] searchRange(int[] nums, int target) {
	        List<Integer> list = new ArrayList<>();
	        if(nums.length == 1 && nums[0] == target){
	            int[] output={0,0};
	            return output;
	        }
	        if(nums.length == 1 && nums[0] != target){
	            int[] output={-1,-1};
	            return output;
	        }
	        for(int i=0;i<nums.length;i++){
	            if(nums[i] == target){
	                list.add(i);
	            }
	            if((nums[i] > target && list.size() > 0) || (i==nums.length-1 && list.size() > 0)){
	               int[] output = new int[list.size()];
	                int index = 0;
	                for(Integer var : list){
	                   output[index] = var;
	                    index++;
	               }
	                return output;
	            }
	        }
	        int[] output = {-1,-1};
	        return output;
	    }

}
