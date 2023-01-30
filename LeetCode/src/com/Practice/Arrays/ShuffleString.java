package com.Practice.Arrays;

public class ShuffleString {
	public static void main(String[] args) {
		String str = "codeleet" ;
		int[] indices = {4,5,6,7,0,2,1,3};
		int index = 0;
		char[] ch =str.toCharArray() ; char[] ans = new char[indices.length];
		for(int i=0;i<indices.length;i++) {
			for(int j=0;j<indices.length;j++) {
				if(indices[j] == i) {
					index = j;
				}
			}
			ans[i] = ch[index];
		}
		String s = new String(ans);
		System.out.println(s);
	}
}