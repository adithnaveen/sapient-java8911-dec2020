package com.sapient.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// program to double the values of the list using map 

public class MapEx01 {
	public static void main(String[] args) {
	 	Integer [] intArray =  {1,2,3,4,5,6,7,8,9,10};
	 	ArrayList<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
	 	
	 	Function<Integer, Integer> timesTwo = (x) -> x * 2; 
	 	
	 	List<Integer> doubled = listOfIntegers
	 		.stream()
	 		.map(timesTwo)
	 		.collect(Collectors.toList()); 
	 	
	 	System.out.println(doubled);
	 	
	 	
	}
}
