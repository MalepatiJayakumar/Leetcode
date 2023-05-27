package com.practice.Interfaces;

import java.util.function.Function;

/*implementing function interface*/
class MyFunction implements Function<String, Integer> {
	@Override
	public Integer apply(String t) {
		return t.length();
	}
}

public class TestFunction {
	public static void main(String[] args) {
		/* Code using implemting Function(I) interface apply method */
		Function<String, Integer> function = new MyFunction();
		Integer size = function.apply("sachin");
		System.out.println(size);

		/* code using Lambda Expressions */
		Function<String, Integer> fun = name -> {
			if (name != null)
				return name.length();
		};
		System.out.println(fun.apply("sachin"));
	}
}