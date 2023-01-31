package com.walmart.Arrays;

public class SortAnArray {
	
	public static void main(String[] args) {
		int[] arr = {0,2,1,2,0};
		arr = sortarray(arr,arr.length);
		System.out.println(arr.length);
	}
	

	static int[] sortarray ( int [] A , int n )  
	{  
	    int low = 0 ;  
	    int mid = 0 ;  
	    int high = n - 1 ;  
	    while ( mid <= high )  
	    {  
	        if ( A [ mid ] == 0 )  
	        {  
	            int temp = A [ mid ] ;  
	            A [ mid ] = A [ low ];  
	            A [ low ] = temp ;  
	            low = low + 1 ;  
	            mid = mid + 1 ;  
	          
	        }  
	        else if ( A [ mid ] == 1 )  
	        {  
	            mid = mid + 1 ;  
	        }  
	        else   
	        {  
	            int temp = A [ mid ] ;  
	            A [ mid ] = A [ high ] ;  
	            A [ high ] = temp ;  
	            high = high - 1 ;  
	              
	        }  
	    } 
	    return A;
	}  

}
