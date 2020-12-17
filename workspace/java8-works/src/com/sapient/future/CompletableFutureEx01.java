package com.sapient.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureEx01 {
	
	static List<String> pets = List.of("Dog", "Cat", "Horse", "Elephanth", "Rat"); 
	
	public static void main(String[] args) {
		getPets()
			.thenApply(pet -> pet.subList(0, 3))
			.thenApplyAsync((i) -> {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("i'm in between... " + Thread.currentThread().getName()); 
				return  i;   
			})
			.thenApply(pet -> pet.stream().sorted().collect(Collectors.toList()))
			.thenApply(pet ->  pet.toString().toUpperCase())
			.thenAccept(System.out :: println); 
		
		System.out.println("i'm at last... ");
	}
	
	private static CompletableFuture<List<String>> getPets(){
		return CompletableFuture.supplyAsync(() -> pets); 
	}
	
}
