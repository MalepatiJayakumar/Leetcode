package com.practice.MultiThreading;

class AdapterClass {
	public void executeThread(String str) {
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(getUpdatedString());
			}
		}).start();
	}
	
	public String getUpdatedString() {
		return "Updated String from method inside AdapterClass";
	}
}

public class Practice1 {
	public static void main(String[] args) {
//		new Thread(() -> {
//			for (int i = 0; i < 5; i++) {
//				System.out.println("Thread using lambda expressions");
//			}
//		}).start();
		
		AdapterClass ad= new AdapterClass();
		ad.executeThread("Thread using lambda expressions");
	}
}
