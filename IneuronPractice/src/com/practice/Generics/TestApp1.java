package com.practice.Generics;

/*Here i am bounding Response object to accept only Number type 
 * which accepts Number and its child types, if we provide interface 
 * it will accept interface type & implementation classes. 
 * If we providing any other types like String we will get Compile time error.
*/
class Response1<T extends Number> {
	Boolean success = Boolean.FALSE;
	T count;

	Response1(Boolean success, T count) {
		this.success = success;
		this.count = count;
	}

	public Boolean getSuccess() {
		return success;
	}

	public T getCount() {
		return count;
	}
}

public class TestApp1 {
	public static void main(String[] args) {
		Response1<Long> res = new Response1<Long>(Boolean.TRUE, 5l); // compiles fine
		System.out.println(res);
		Response1<Double> res1 = new Response1<Double>(Boolean.TRUE, 5d);
		System.out.println(res1);
	}
}
