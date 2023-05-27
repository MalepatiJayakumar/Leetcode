package com.practice.ExceptionHandling;

class TestDTO {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Alpha1 {

	public TestDTO testFinallyBlock() {
		TestDTO dto = new TestDTO();

		try {
//			int x = 100/0;
			return dto;
		} catch (Exception e) {
			return dto;
		} finally {
			System.out.println("Inside finally Block");
			dto.setName("JaiKumar");
		}
	}
}

public class CheckFinallyBlockExecution {

	public static void main(String[] args) {
		Alpha1 obj = new Alpha1();
		TestDTO dto = obj.testFinallyBlock();
		System.out.println(dto.getName());
	}
}
