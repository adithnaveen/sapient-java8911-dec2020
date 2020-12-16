package com.sapient.function;

import java.util.function.BiFunction;
import java.util.function.Function;

// showing working of partial value passing / currying 
// you dont have to send all the values in 1 go 
public class CurryingEx01 {
	public static void main(String[] args) {
		// version 1 
		TriFunction<Integer, Integer, Integer, Integer> add = 
				(x, y, z) -> x + y + z; 
				
		// version 2.0 		
		// 3 = 2 (BiFunction)-1 (Function)  		
		BiFunction<Integer, Integer, Function<Integer, Integer>> addPartial = (x, y) -> (z) -> add.apply(x, y, z);  
		
		Function<Integer, Integer> add3And2 = addPartial.apply(100, 200); 
		Integer add123 = add3And2.apply(300); 
		System.out.println(add123);
		
		// version 3.0 
		
		Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartial1 = 
				(x) -> (y) -> (z) -> add.apply(x, y, z); 
				
		Function<Integer, Function<Integer, Integer>> add1 = addPartial1.apply(1); 
		Function<Integer,Integer> add2 = add1.apply(2);
		Integer sum = add2.apply(3); 

		System.out.println("Sum : "+ sum );
		
				
		
	}
}
