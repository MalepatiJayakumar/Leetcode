package com.Practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemMatchingRule {
	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int outputCount = 0 , index = 0; 
        for(List<String> list : items){
            index = 0;
            for(String str : list){
                if(ruleKey == "type" && ruleValue == str && index == 0){
                    outputCount++;
                }
                else if(ruleKey == "color" && ruleValue == str && index == 1){
                    outputCount++;
                }
                else if(ruleKey == "name" && ruleValue == str && index == 2){
                    outputCount++;
                }
                index++;
            }
        }
        return outputCount;
    }
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		List<String> list1 = Arrays.asList("Phone","blue","pixel");
		List<String> list2 = Arrays.asList("computer","silver","lenovo");
		List<String> list3 = Arrays.asList("phone","gold","iphone");
		list.add(list1);
		list.add(list2);
		list.add(list3);
		String ruleKey = "color", ruleValue = "silver";
		int output = countMatches(list,ruleKey,ruleValue);
		System.out.println(output);
	}

}
