package com.Practice.Arrays;

import java.util.Arrays;

/*
 *          Input: m = 2, n = 3, indices = [[0,1],[1,1]]
            Output: 6
            Explanation: Initial matrix = [[0,0,0],[0,0,0]].
            After applying first increment it becomes [[1,2,1],[0,1,0]].
            The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 */
public class CellsWithOddValuesInMatrix {
	public static void main(String[] args) {
		int[][] indices = {{0,1},{1,1}};
		int m = 2,n=3;
		System.out.println(oddCells(m,n,indices));
	}
	public static int oddCells(int m, int n, int[][] indices) {
		int[][] matrix = new int[m][n];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = 0;
			}
		}
//		Arrays.fill(matrix,0);
        for(int i=0;i<indices.length;i++) {
        	int rlen = n-1;
        	while(rlen >= 0) {
    			matrix[indices[i][0]][rlen] = matrix[indices[i][0]][rlen] + 1;
    			rlen--;
    		}
        	int clen = m-1;
        	while(clen >= 0) {
        		matrix[clen][indices[i][1]] = matrix[clen][indices[i][1]] + 1;
        		clen--;
        	}
//        	matrix = rowUpdate(indices[i][0],matrix , m);
//        	matrix = colUpdate(indices[i][1],matrix , n);
        }
        int outputCount = 0;
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[i].length;j++) {
        		if(matrix[i][j] % 2 != 0) {
        			outputCount++;
        		}
        	}
        }
        return outputCount;
    }

}
