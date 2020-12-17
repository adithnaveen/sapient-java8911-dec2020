package com.sapient.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureEx03 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		getData1().thenCombine(getData2(), (s1, s2) -> s1 + s2).thenAccept(System.out :: println); 
		
		
		System.out.println("-----------------------------");
		
//		
//		System.out.println("String from Joining : "  + 
//		Stream.of(getData("Bengaluru"), getData("Delhi"), getData("Virginia"))
//			.map(CompletableFuture :: join).collect(Collectors.joining(" - "))); 
		
		
		worker(); 
		
		ExecutorService executor = Executors.newFixedThreadPool(10); 
		
		
		
		
		
		
	}
	
	private static void worker() throws InterruptedException, ExecutionException {
		CompletableFuture<String> req1 = getData("Hello"); 
		CompletableFuture<String> req2 = getData("How"); 
		CompletableFuture<String> req3 = getData("Are You"); 
		
//		System.out.println(req1.get()); 
//		System.out.println(req2.get()); 
//		System.out.println(req3.get()); 
		
//		CompletableFuture<Void> allOf = CompletableFuture.allOf(req1, req2, req3); 
//		allOf.get(); 
		
		CompletableFuture<Object> anyOf = CompletableFuture.anyOf(req1, req2, req3);
		anyOf.get(); 
		
		System.out.println("I'm last line... ");
		
	}
	
	private static CompletableFuture<String> getData1 () {
		return CompletableFuture.supplyAsync(() -> "India"); 
	}

	private static CompletableFuture<String> getData2 () {
		return CompletableFuture.supplyAsync(() -> "Sapient").orTimeout(1, TimeUnit.SECONDS); 
	}

	private static CompletableFuture<String> getData (String data) {
		return CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			System.out.println("Thread Name : " + Thread.currentThread().getName());
			return data; 
		}); 
	}
	
	
	static void sleep(int i ) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}










