package com.sapient.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorEx01 {
	public static void main(String[] args) {
		
		List<Product> list = 	Arrays.asList(
		
				new Product("laptop", 33, new BigDecimal("650000.00")), 
				new Product("laptop", 12, new BigDecimal("32000.00")), 
				new Product("marker", 133, new BigDecimal("15.85")), 
				new Product("marker", 133, new BigDecimal("15.85")), 
				new Product("marker", 22, new BigDecimal("18.55")), 
				new Product("paper", 66, new BigDecimal("10.00")), 
				new Product("paper", 9, new BigDecimal("7.00")) 
		); 
	
		Map<String, Integer> sum = list.stream()
			.collect(
					Collectors.groupingBy(Product :: getName, Collectors.summingInt(Product:: getQty))
					);
		
		System.out.println(sum);
		
		Map<BigDecimal, List<Product>> groupByPriceMap = list.stream()
			.collect(Collectors.groupingBy(Product :: getPrice)); 
		
		System.out.println(groupByPriceMap);
		
		// since we want as a set it will maintain only uniq entries 
		
		Map<BigDecimal, Set<Product>> groupByPriceSet = list.stream()
		.collect(Collectors.groupingBy(Product :: getPrice, Collectors.toSet())); 
		
		System.out.println(groupByPriceSet);
		
		
		System.out.println("-----------------------------------------------");
	
		Map<BigDecimal, Set<String>> groupByPriceMappingOnlyName = list.stream()
			.collect(
					Collectors.groupingBy(Product :: getPrice, 
							Collectors.mapping(Product:: getName, Collectors.toSet())) 
				); 
		
		System.out.println(groupByPriceMappingOnlyName);
		
		
		
		System.out.println("-----------------------------------------------");
	
		Map<BigDecimal, List<String>> groupByPriceMappingOnlyName1 = list.stream()
			.collect(
					Collectors.groupingBy(Product :: getPrice, 
							Collectors.mapping(Product:: getName, Collectors.toList())) 
				); 
		
		System.out.println(groupByPriceMappingOnlyName1);
		
		System.out.println("-----------------------------------------------");
	
		Map<BigDecimal, Set<Integer>> groupByPriceMappingOnlyQty = list.stream()
			.collect(
					Collectors.groupingBy(Product :: getPrice, 
							Collectors.mapping(Product:: getQty, Collectors.toSet())) 
				); 
		
		System.out.println(groupByPriceMappingOnlyQty);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
