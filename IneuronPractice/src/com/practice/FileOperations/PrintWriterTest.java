package com.practice.FileOperations;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/*PrintWriter is the best stream to Write data in File*/
public class PrintWriterTest {
	public static void main(String[] args) throws IOException {
//		FileWriter fw = new FileWriter("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
		/* Here i have give the file object, we can pass writer object to PrintWriter */
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt"));
		/*
		 * BufferedWriter bw = new BufferedWriter(fw)
		 * these methods comes from write object which is parent of BufferedReader , FileReader & PrintWriter
		 * bw.write("Starting the next chapter");
		 *  bw.nextLine();
		 */
			
		/* Instead of above 2 lines to write data in next line , we can use single method println() in printWriter to write in next line */ 
		pw.println("Starting the next chapter");
		
		/* Internally closes FileWriter & printWriter Objects, no need to close explicitly */
		pw.close();
	}
}
