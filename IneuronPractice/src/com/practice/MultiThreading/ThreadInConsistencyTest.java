package com.practice.MultiThreading;

class Display {
	public void display(String name) {
		for(int i=0;i<5;i++) {
			System.out.print("Good evening :: ");
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				System.out.println("Interrupted");
			}
			System.out.println(name);
		}
	}
}
class MyThread1 implements Runnable {
	Display d;
	String name;
	
	MyThread1(Display d, String name){
		this.d = d;
		this.name = name;
	}
	@Override
	public void run() {
		d.display(name);
	}
}

public class ThreadInConsistencyTest {
	public static void main(String[] args) {
		Display d= new Display();
		Display d1= new Display();
		MyThread1 t1= new MyThread1(d,"Jai");
		MyThread1 t2= new MyThread1(d1,"Kumar");
		new Thread(t1).start();
		new Thread(t2).start();
	}
	
	//Output --> Inconsistency data
	
	/*Good evening :: Good evening :: Jai
	Good evening :: Kumar
	Good evening :: Jai
	Good evening :: Kumar
	Good evening :: Jai
	Good evening :: Kumar
	Good evening :: Kumar
	Good evening :: Jai
	Good evening :: Kumar
	Jai */
}
