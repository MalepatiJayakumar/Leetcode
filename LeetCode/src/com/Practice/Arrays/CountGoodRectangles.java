package com.Practice.Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class CountGoodRectangles {
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
		int[][] arr = {{2,3},{3,7},{4,3},{3,7}};
	    int result = countGoodRectangles(arr);
	    System.out.println(result);
	}
	public static int countGoodRectangles(int[][] rectangles) {
		
        for(int i=0;i<rectangles.length;i++){
            checkMap(rectangles[i][0]);
            checkMap(rectangles[i][1]);
        }
        int maxValueInMap=(Collections.max(map.values()));
        int key = 0;
        for (HashMap.Entry<Integer,Integer> mapElement : map.entrySet()) {
            if(mapElement.getValue() == maxValueInMap) {
            	key = mapElement.getKey();
            }
        }
        int count = 0;
        for(int i=0;i<rectangles.length;i++) {
        	if(rectangles[i][0]==key || rectangles[i][1]==key) {
        		if(rectangles[i][0]==key && rectangles[i][1]==key) {
        			count++;
        		}
        		else if(rectangles[i][0]==key && rectangles[i][1]>key) {
        			count++;
        		}
        		else if(rectangles[i][0]>key && rectangles[i][1]==key) {
        			count++;
        		}
        	}
        }
		return count;
    }
	public static int checkMap(int i) {
		if(map.containsKey(i)) {
			int count = map.get(i);
			map.put(i,count+1);
		}
		else {
			map.put(i,1);
		}
		return 0;
		
	}

}
