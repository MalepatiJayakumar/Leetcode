package com.practice.FileOperations;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;

import com.practice.Utilities.Constants;
import com.practice.Utilities.Response;
import com.practice.bean.Dog;

/* Save & Fetch Object from File using serialization & De-Serialization */
public class StoreAndFetchObject {
	public static <T> void main(String[] args) throws IOException, ClassNotFoundException {
		String fileName = FileHelper.folderPath + "serializedFile.ser";
		Dog dog = new Dog(1, Constants.BROWNI, Constants.CHICKEN);
		FileHelper.saveObjectInFile(fileName, Arrays.asList(dog));
		Response<List<Object>> response = FileHelper.readObjectFromFile(fileName);
		if (response.getSuccess()) {
			Dog output = (Dog) response.getOutput().get(0);
			System.out.println("Response :: " + output);
		}
	}
}