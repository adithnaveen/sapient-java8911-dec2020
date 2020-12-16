package com.sapient.function;

import java.util.function.Function;

public class ClosureEx01 {
	
	// closure is combination of function, bundled together with references 
	// surrounding the state 
	// you can access to another functions scope from an inner function 
	
	static Function<Integer, String> getTextOfWeek() {
		String [] weeks = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
		
		// privileged inner function 
		return num -> (num > 0 && num <= weeks.length)? weeks[num-1] : null;
		
	}
	
	public static void main(String[] args) {
		NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
			// the variable name is defined inside the curly braces 
			// this variable scope is available outside 
			String name = "Harry"; 
			return () -> "Hello : " + name;
		}; 
		
		NoArgFunction<String> greeter = createGreeter.apply(); 
		// note here when you call greeter.apply() it says Hello Harry where 
		// the variable name="Harry" is defined inside inner function 
		
		System.out.println(greeter.apply());
		
		System.out.println(getTextOfWeek().apply(4));
		
		
	}
}
