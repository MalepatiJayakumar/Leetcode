package com.Practice.Arrays;
import java.util.*;

public class DiagonalSumOfAnArray {
	public static void main(String[] args) {
		int[][] mat = {{7,9,8,6,3},{3,9,4,5,2},{8,1,10,4,10},{9,5,10,9,6},{7,2,4,10,8}};
		System.out.println(diagonalSum(mat));	
	}
	public static int diagonalSum(int[][] mat) {
		 int sum = 0;
	        if(mat.length == 1){
	            return mat[0][0];
	        }
	        int j =0;
	        for(int i=0;i<mat.length;i++){
	           sum = sum +mat[i][i];
	           sum = sum + mat[i][mat.length-j-1]; 
	        }
	        return sum;
    }
}
