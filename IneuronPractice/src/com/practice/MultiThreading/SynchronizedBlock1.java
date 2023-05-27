package com.practice.MultiThreading;

class Display5{
	public void testSynchronizedBlock(String name) {
		System.out.println("Entered testSynchronizedBlock with name :: "+name);
		// creates an class level lock for that particular block of code, class level lock because we are using synchronized for class
		synchronized(Display5.class) {
			System.out.println("Lock acquired by :: "+Thread.currentThread().getName());
			try {
				for(int i=0;i<5;i++) {
					Thread.sleep(2000);
					System.out.println(name);
				}
				
			}
			catch(Exception e) {
				
			}
			System.out.println("Lock released by :: "+Thread.currentThread().getName());
		}
		System.out.println("Completed execution of testSynchronizedBlock with name :: "+name);
	}
}
class Display4AdapterClass1 implements Runnable {
	Display5 d;
	String name;
	
	Display4AdapterClass1(Display5 d, String name){
		this.d=  d;
		this.name=name;
	}
	
	@Override
	public void run() {
		d.testSynchronizedBlock(name);
	}
}

public class SynchronizedBlock1 {
	public static void main(String[] args) {
		Display5 d= new Display5();
		Display5 d1= new Display5();
		Display4AdapterClass1 adapter= new Display4AdapterClass1(d,"jai");
		Display4AdapterClass1 adapter1= new Display4AdapterClass1(d1,"kumar");
		Thread jai= new Thread(adapter);
		Thread kumar= new Thread(adapter1);
		jai.setName("jai");
		kumar.setName("kumar");
		jai.start();
		kumar.start();
	}
}
