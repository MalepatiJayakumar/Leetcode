package com.practice.FileOperations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.practice.Utilities.Constants;
import com.practice.Utilities.Response;
import com.practice.bean.Branch;
import com.practice.bean.Student;

public class SerializeInnerObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student std = new Student();
		Branch branch = new Branch();
		branch.setBranchId(1);
		branch.setBranchName(Constants.COMPUTER_SCIENCE);
		branch.setBranchLocation(Constants.ADDRESS);
		std.setId(1);
		std.setName(Constants.JAI);
		std.setAddress(Constants.ADDRESS);
		std.setBranch(branch);
		
		String filePath = FileHelper.folderPath+"innerObject.ser";
		FileHelper.saveObjectInFile(filePath,Arrays.asList(std));
		
		Response<List<Object>> output = FileHelper.readObjectFromFile(filePath);
		if(output.getOutput().get(0) instanceof Student) {
			Student std1 = (Student) output.getOutput().get(0);
			System.out.println("Branch name :: "+std1.getBranch().getBranchName());
		}
	}
}
