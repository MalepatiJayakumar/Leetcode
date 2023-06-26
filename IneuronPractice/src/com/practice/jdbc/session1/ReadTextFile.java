package com.practice.jdbc.session1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class ReadTextFile {
	
	public static void main(String[] args) {
		try{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter file path");
			String  location = scan.next();
			File file = new File(location);
			FileReader fr = new FileReader(file);
			
			
			fr.close();
			scan.close();
		}catch(IOException e) {
			System.out.println("Exception occured while reading file "+e);
		}
	}

}
