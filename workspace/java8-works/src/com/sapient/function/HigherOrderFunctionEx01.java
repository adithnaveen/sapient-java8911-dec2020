package com.sapient.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctionEx01 {
	public static void main(String[] args) {
		// num1 / num2
		
		BiFunction<Float, Float, Float> divide = (x, y) -> x/ y ; 
		
		
		
		//            source 						 return 
		Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>>
			secondArgIsntZeroChecker = (func) -> (x, y) -> {
				
				if(y ==0f) {
					System.out.println("Error : Second argument is zero");
					return 0f; 
				}
				return func.apply(x, y); 
			}; 
		
		
		BiFunction<Float, Float, Float> divideSafe = secondArgIsntZeroChecker.apply(divide); 
		
		System.out.println(divideSafe.apply(100f, 5f));
			
//		System.out.println(divide.apply(100f, 0f));
	}
}
