package com.Practice.Arrays;
/*Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]  */
public class CreateTargetArray {
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4};
		int[] index = {0,1,2,2,1};
		int[] ans = new int[nums.length];
		for(int i=0;i<index.length;i++) {
			int value = nums[i];
			int in = index[i];
			for(int j=nums.length-2;j>=in;j--) {
				ans[j+1] = ans[j];
			}
			ans[in] = value;
		}
		for(int a : ans) {
			System.out.println(a);
		}
	}

}
