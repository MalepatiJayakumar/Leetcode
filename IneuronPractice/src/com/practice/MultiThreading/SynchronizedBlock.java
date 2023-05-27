package com.practice.MultiThreading;

class Display4{
	public void testSynchronizedBlock(String name) {
		System.out.println("Entered testSynchronizedBlock with name :: "+name);
		// creates an object level lock for that particular block of code, object level lock because we are using this reference
		synchronized(this) {
			try {
				for(int i=0;i<5;i++) {
					Thread.sleep(2000);
					System.out.println(name);
				}
				
			}
			catch(Exception e) {
				
			}
		}
		System.out.println("Completed execution of testSynchronizedBlock with name :: "+name);
	}
}
class Display4AdapterClass implements Runnable {
	Display4 d;
	String name;
	
	Display4AdapterClass(Display4 d, String name){
		this.d=  d;
		this.name=name;
	}
	
	@Override
	public void run() {
		d.testSynchronizedBlock(name);
	}
}
public class SynchronizedBlock {
	public static void main(String[] args) {
		
		Display4 d= new Display4();
		Display4 d1= new Display4();
		Display4AdapterClass adapter= new Display4AdapterClass(d,"jai");
		Display4AdapterClass adapter1= new Display4AdapterClass(d1,"kumar");
		new Thread(adapter).start();
		new Thread(adapter1).start();
	}
}
