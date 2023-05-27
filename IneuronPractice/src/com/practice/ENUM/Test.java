package com.practice.ENUM;

enum Result {
	PASS, FAIL, NR;
	// internally above 3 constants creates three objects as below, so constructor
	// will be called as per number of constant objects created in enum
	// public static final Result PASS= new Result();
	// public static final Result FAIL= new Result();
	// public static final Result NR= new Result();
	
	// we can also use constructor(can't make it public) , methods,instant variables in enums
	
	private Long id;
	
	Result(){
		System.out.println("Constructor in enum");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

public class Test {
	public static void main(String[] args) {
		Result res= Result.PASS; // gets pass object
		Result[] res1= Result.values();
		
		switch(res) {
			case PASS:
				System.out.println("Passed in examination");
				break;
			case FAIL:
				System.out.println("Failed in examination");
				break;
			case NR:
				System.out.println("No results found");
		}
	}
}
