package com.practice.Static;

class CheckStatic{
    //memory for variable a & b will be executed at linking state in class loader subsystem
	static int a;
	static int b;
	
	//static block will be executed at initialization state in class loader subsystem
	static {
		System.out.println("Assigning values to static variables");
		a = 10;
		b = 20;
	}
	
	static void display() {
		System.out.println("values of a & b are  :: "+a +" "+b);
	}
	
	int x_ins;
	int y_ins;
	
	//java Block / instance block
	{
		System.out.println("Assigning values to instance variables");
		x_ins = 5;
		y_ins = 10;
	}
	void disp() {
		System.out.println("values of instance variables x & y are :: "+x_ins +" "+y_ins);
	}
	
}

public class StaticBehaviour {
	
	public static void main(String[] args) {
		// Static variables & static blocks are not dependent on object creation so we can't use instance variables inside static block
		CheckStatic.display();              
		// Here we will get initialization of instance variables
		CheckStatic obj = new CheckStatic();
		obj.disp();   
		
		/*
		 * Output ::
		 * =========
		 * Assigning values to static variables
		 * values of a & b are :: 10 20 
		 * Assigning values to instance variables
		 * values of instance variables x & y are :: 5 10
		 */
	}

}
