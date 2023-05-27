package com.practice.Programs;

class ConstructorCheck{
	
	ConstructorCheck(){
		this(5);
	}
	
	ConstructorCheck(int a){
		System.out.println(a);
	}
}

class InstanceBlockExecutionCheck{
	//instance block includes in constructor at the time of execution
	{
		System.out.println("Inside Instance Block");
	}
	InstanceBlockExecutionCheck(){
		System.out.println("Inside InstanceBlockExecutionCheck constructor");
	}
	
//	JVM code execution
	
//	InstanceBlockExecutionCheck(){
//		{
//			System.out.println("Inside Instance Block");
//		}
//		System.out.println("Inside InstanceBlockExecutionCheck constructor");
//	}
}

public class CheckStringBufferBehaviour {
	
	public static void main(String[] args) {
		
		final StringBuffer sb= new StringBuffer("jai ");
		sb.append("kumar");
		sb.append(" reddy"); // even sb is final StringBuffer behaviour is to changes content so we are able to modify content but we can't change reference
		
//		sb= new StringBuffer("Dhanusuh"); 
		
		
		ConstructorCheck obj= new ConstructorCheck();
		
		InstanceBlockExecutionCheck obj1= new InstanceBlockExecutionCheck();
	}

}
