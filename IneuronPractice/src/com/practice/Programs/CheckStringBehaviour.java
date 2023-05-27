package com.practice.Programs;

public class CheckStringBehaviour {
	
	public static void main(String[] args) {
		String str1= "jai"; //creates entry in SCP & str1 is mapped to jai in SCP
		String str2= new String("jai"); // creates entry in heap and checks in SCP, as jai content is present it is not going to create new object in SCP
		System.out.println(str1== str2);
		
		String str3= str2.intern();      // checks for str2 content in SCP and maps s3 to jai object
		System.out.println(str3 == str2); // str2 --> mapped to object in heap memory & str3 is mapped to object in SCP , so it returns false
		
		System.out.println(str1 == str3); // here s1 & s3 are mapped to same object, so it will return true
	}

}
