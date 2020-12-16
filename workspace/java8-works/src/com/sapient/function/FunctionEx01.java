package com.sapient.function;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class FunctionEx01 {
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
		System.out.println("Result is : " + add.apply(10, 20));

		TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
		System.out.println("Adding 3 Values " + addThree.apply(10, 20, 30));

		NoArgFunction<String> sayHello = () -> "Hello "; 
		System.out.println( "Returned from NoArgFunction: "+ sayHello.apply());
		
		Supplier<Developer> developerSupplier = () -> new Developer("Harry"); 
		
		Developer developer = developerSupplier.get(); 
		System.out.println(developer);
		
	}
}
