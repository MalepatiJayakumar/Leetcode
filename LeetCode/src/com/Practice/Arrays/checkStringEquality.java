package com.Practice.Arrays;

public class checkStringEquality {
	public static void main(String[] args) {
		String[] word1 = {"ab", "c"};
		String[] word2 = {"a", "bc"};
		boolean result = arrayStringsAreEqual(word1,word2);
		System.out.println(result);
	}
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String value="";
        for(int i=0;i<word1.length;i++){
            value = value + word1[i];
        }
        String str = "";
        for(int i=0;i<word2.length;i++){
            str = str + word2[i];
        }
        System.out.println(value.trim());
        System.out.print(str.trim());
        if(value.equals(str)){
            return true;
        }
        str.contains(value);
        char[] ch = str.toCharArray();
        return false;
    }

}
