package com.sapient.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx04 {
	public static void main(String[] args) {
		List<Office> offices = Arrays.asList(
				new Office("Sapient", "India"), 
				new Office("Infosys", "USA"), 
				new Office("ProBits", "France"), 
				new Office("Sapient", "France"), 
				new Office("Infosys", "India") 
		); 
		
		
		// to get the count of companies WRT name 
		Map<String, Long> counting = offices.stream().collect(
				Collectors.groupingBy(Office :: getName, Collectors.counting())
		);
		
		System.out.println(counting);
		
		// to get the count of companies WRT name
		Map<String, Long> countingOnCountry = offices.stream().collect(
			Collectors.groupingBy(Office::getCountry, Collectors.counting())	
		); 
		
//		System.out.println(countingOnCountry);
		
		// lambda way 
		countingOnCountry.forEach( (k, v) -> System.out.println(k +":"+ v));
		
		System.out.println("in stream way... ");
		// stream way 
		countingOnCountry.entrySet().stream()
		.forEach(e -> System.out.println( e.getKey() +", " + e.getValue() ));
	}
}














