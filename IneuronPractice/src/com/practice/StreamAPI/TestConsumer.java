package com.practice.StreamAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class MyConsumer<T> implements Consumer<T>{
	/* accept methods accepts what ever we pass to it */
	@Override
	public void accept(T t) {
		System.out.println(t);
	}
}

public class TestConsumer {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("sachin","dhoni","kohli","rohit"));
		
		/*
		 * forEach accepts consumer type & internally calls consumer class accept method as below
		 */ 
//		default void forEach(Consumer<? super T> action) {
//	        Objects.requireNonNull(action);
//	        for (T t : this) {
//	            action.accept(t);
//	        }
//	    }
		
		MyConsumer<String> consumer = new MyConsumer<String>();
		/*
		 * calling implemented accept method to print elements present in list one by one
		 */
		System.out.println("Printing names using consumer interface implementation");
		list.forEach(consumer);//backed --> accept("sachin") , accept("dhoni")...
		
		System.out.println();
		
		/*
		 * As consumer is an functional interface we can use lambda expression to print
		 * names in list as below
		 */
		System.out.println("Printing names using consumer lambda expressions");
		list.forEach(name->System.out.println(name));
		
		System.out.println();
		
		/* printing names using method reference */
		System.out.println("Printing names using method reference");
		list.forEach(System.out::println); // backend --> name->sysout(name)
	}
}
