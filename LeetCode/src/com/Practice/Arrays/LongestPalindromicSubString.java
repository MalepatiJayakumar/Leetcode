package com.Practice.Arrays;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String output = longestSubString(
				"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
		System.out.println(output);
	}

	public static String palindrome(String str1, String output) {
		char[] check = str1.toCharArray();
		int j = str1.length()/2;
		int i = str1.length()/2;
		if((str1.length()/2) % 2 == 0 ) {
			i=(str1.length()/2)-1;
		}
		Boolean palindrome = true;
		while(i>=0 && j<str1.length()) {
			if(check[i] != check[j]) {
				palindrome = false;
				break;
			}
			i--;
			j++;
		}
		if (palindrome) {
			return str1;
		}
		return output;
	}

	public static String longestSubString(String str) {
		char[] ch = str.toCharArray();
		String returnOutput = String.valueOf(ch[0]);
		String output = "";
		if (ch.length > 1) {
			for (int i = 0; i < ch.length; i++) {
				String s = String.valueOf(ch[i]);
				for (int j = i + 1; j < ch.length; j++) {
					s += String.valueOf(ch[j]);
					if (returnOutput.length() < s.length()) {
						returnOutput = palindrome(s, returnOutput);
					}
				}
			}
		} else {
			return str;
		}

		return returnOutput;
	}

}
