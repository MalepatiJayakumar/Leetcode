package com.practice.MultiThreading;

class Computation {
	public static Integer total= 0;
	public void calculateTotal(String user) throws InterruptedException{
		synchronized(this) {
			System.out.println(user+" acquired lock for computation");
			for(int i=0;i<10;i++) {
				total=+i;
			}
			System.out.println(user+" releasing lock from computation");
			this.notify();
		}
		Thread.sleep(3000);
	}
}

class MyRunnable1 implements Runnable {
	String userName;
	Computation obj;
	
	MyRunnable1(String userName,Computation obj){
		this.obj= obj;
		this.userName=userName;
	}
	
	@Override
	public void run() {
		try {
			obj.calculateTotal(userName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class WaitAndNotiftyThread {
	
	public static void main(String[] args) throws InterruptedException {
		MyRunnable1 r= new MyRunnable1("Jai",new Computation());
		Thread t= new Thread(r);
		t.start();
		
		synchronized(r) {
			System.out.println("Entered into synchronized block before calling wait");
			r.wait();
			System.out.println("complete wait method execution");
		}
	}

}
