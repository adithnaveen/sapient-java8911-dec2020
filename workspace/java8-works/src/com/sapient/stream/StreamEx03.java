package com.sapient.stream;

import java.time.LocalTime;
import java.util.stream.IntStream;

public class StreamEx03 {
	public static void main(String[] args) {
		
//		IntStream stream = IntStream.range(1, 5); 
		IntStream stream = IntStream.range(1, 5).parallel(); 
		
		stream = 
		stream.peek(i -> log("starting value ", i))
					.filter(i -> {
						log("Filtering ", i); 
						return i%2==0;
					}) 
					.peek(i -> log("post filter", i)); 
		
		log("invoking terminal method, count ");    // 1st to executed 
		log("The count is " , stream.count()); // the streams are called only upon executing non-streams 
		
		
		
		
	}
	
	private static void log(Object ...objects) {
		String string = LocalTime.now().toString();
		for(Object object: objects) {
			string += " - " + object.toString();
		}
		
		System.out.println(string);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
