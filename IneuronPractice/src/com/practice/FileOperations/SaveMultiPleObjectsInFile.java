package com.practice.FileOperations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.practice.Utilities.Constants;
import com.practice.Utilities.Response;
import com.practice.bean.Account;
import com.practice.bean.Dog;

/*save Multiple objects in serialized file , But while De-serializing we should de-serialize in same sequence otherwise it will give classCastException*/
public class SaveMultiPleObjectsInFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String fileName = FileHelper.folderPath + "multiObject.ser";
		Account account = new Account(Constants.JAI, Constants.BANK_NAME, Constants.ACCOUNT_TYPE);
		Dog dog = new Dog(1, Constants.BROWNI, Constants.CHICKEN);
		FileHelper.saveObjectInFile(fileName, Arrays.asList(account, dog));
		Response<List<Object>> response = FileHelper.readObjectFromFile(fileName);
		if (response.getSuccess()) {
			/*
			 * file will store as account , dog sequence so while accessing also we need to
			 * accessing in same sequence otherwise it will give exception as below
			 * Exception in thread "main" java.lang.ClassCastException: class
			 * com.practice.bean.Account cannot be cast to class com.practice.bean.Dog
			 * (com.practice.bean.Account and com.practice.bean.Dog are in unnamed module of
			 * loader 'app')
			 */
//			Dog output = (Dog) response.getOutput();
//			System.out.println("Response :: " + output);

			Account accoutOutput = (Account) response.getOutput().get(0);
			Dog dogOutput = (Dog) response.getOutput().get(1);
			System.out.println("Account output :: " + accoutOutput);
			System.out.println("Dog output :: " + dogOutput);
		}
	}
}
