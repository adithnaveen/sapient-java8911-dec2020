package com.sapient.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

class OrderEntry {
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	} 
	
	public OrderEntry(int amount ) {
		this.amount = amount; 
	}
}

public class CollectorsEx02 {
	public static void main(String[] args) {
		List<OrderEntry> list = Arrays.asList(
			
				new OrderEntry(123), 
				new OrderEntry(45), 
				new OrderEntry(77), 
				new OrderEntry(12), 
				new OrderEntry(56), 
				new OrderEntry(23)
			); 
		
		IntSummaryStatistics stats = list.stream().mapToInt(
					(x) -> x.getAmount()
				).summaryStatistics(); 

		
		// average 
		System.out.println("Average : " + stats.getAverage());
		// sum 
		System.out.println("Sum " + stats.getSum());
		// min 
		System.out.println("Min " + stats.getMin());
		// max
		System.out.println("Max : " + stats.getMax());
		// count 
		System.out.println("Count : " + stats.getCount());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
