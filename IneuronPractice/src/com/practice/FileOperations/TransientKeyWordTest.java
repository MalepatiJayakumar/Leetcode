package com.practice.FileOperations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.practice.Utilities.Constants;
import com.practice.Utilities.Response;
import com.practice.bean.Account;
import com.practice.bean.Dog;

/* trasient key word is applicable for variable , where it won't participate in serializations, JVM assignes default value to those variables while doing serialization */
/* transient won't work with static or final keywords -->
 *  final(when we use final JVM works with value where as JVM can't change any value), 
 *  static (static variable vallue will be present outside object, so JVM can't do anything)
 */
public class TransientKeyWordTest {
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		String fileName = FileHelper.folderPath + "transientKeyWord.ser";
		/* Account --> password is an transient variable */
		Account account = new Account("jaiKumar", "123456", "jaikumar@gmail.com");
		/* Dog --> age(static & transient) */
		Dog dog = new Dog(1, Constants.BROWNI, Constants.CHICKEN);
		FileHelper.saveObjectInFile(fileName, Arrays.asList(account, dog));
		Response<List<Object>> output =  FileHelper.readObjectFromFile(fileName);
		if(output.getSuccess()) {
			List<Object> data = output.getOutput();
			for(Object obj : data) {
				if(obj instanceof Account) {
					Account accountOutput = (Account)data.get(0);
					System.out.println("Account data after De-Serialization :: "+accountOutput);
				}
				if(obj instanceof Dog) {
					Dog dogOutput = (Dog)data.get(1);
					System.out.println("Dog data after De-Serialization :: "+dogOutput);
				}
			}
		}
	}
}
/* Ouptut :- 
 * Getting null for transient variables
 * Account [userName=jaiKumar, password=null, email=jaikumar@gmail.com]
 * Dog [age=1, name=null, favorateFood=chicken]
 */