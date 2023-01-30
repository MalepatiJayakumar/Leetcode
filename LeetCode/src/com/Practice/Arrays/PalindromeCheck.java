package com.Practice.Arrays;

public class PalindromeCheck {
	public static void main(String[] args) {
		String[] words = {"abc","car","ada","racecar","cool"};
		firstPalindrome(words);
	}
	public static String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            String current = words[i];
            String reverse = "";
            for(int j=current.length()-1;j>=0;j--){
                reverse = reverse + words[i].charAt(j);
            }
            if(reverse.equals(current)){
                return reverse;
            }
        }
        return "";
    }

}
