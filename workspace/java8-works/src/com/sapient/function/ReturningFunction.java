package com.sapient.function;

import java.util.function.Function;

public class ReturningFunction {
	
	private static class MyMath {
		// some common operations which are similar 
		// multiple function (these functions return the data) 
		
		public static Integer timesTwo(Integer x)  {
			return x * 2; 
		}
		
		public static Integer timesThree(Integer x)  {
			return x * 3; 
		}
		
		public static Integer timesFour(Integer x)  {
			return x * 4; 
		}
		
		
		public static Function<Integer, Integer> createMultiplier(Integer y) {
			return (Integer x) -> x * y; 
		}
	}
	
	public static void main(String[] args) {
		NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello Functional!!!!"; 
		
		NoArgFunction<String> greeter = createGreeter.apply(); 
		
		String greet = greeter.apply(); 
		System.out.println("Msg: " + greet);
		
		// it is returning you a function 
		Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
		Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
		Function<Integer, Integer> timesFour = MyMath.createMultiplier(4);
		
		System.out.println(timesTwo.apply(6));  
		System.out.println(timesThree.apply(6));
		System.out.println(timesFour.apply(6));
		
	}
}

















