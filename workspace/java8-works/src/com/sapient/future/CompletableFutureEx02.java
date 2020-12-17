package com.sapient.future;

import java.util.concurrent.CompletableFuture;

class Transaction {
	public int getBalance() {
		System.out.println("In Transaction : " + Thread.currentThread());
		
		// kill some time 
		for(int i=0; i<50000; i++) {System.out.print("");}
		return (int) (Math.random()*10000); 
	}
}

public class CompletableFutureEx02 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("In Main : Thread : " + Thread.currentThread());
//		singleThreadedModel();
		
		System.out.println("----------------------------------------");
		
		completableMethod01(); 
		System.out.println("----------------------------------------");
		completableMethod02(); 
	}
	

	private static void completableMethod01() {
		Transaction transaction = new Transaction(); 
		System.out.println("Inside completableMethod01() -> " + Thread.currentThread());
		completableFuture(transaction).thenAccept(balance -> display(balance)); 
	}
	
	
	
	
	

	private static void completableMethod02() throws InterruptedException {
		Transaction transaction = new Transaction(); 
		System.out.println("Inside completableMethod01() -> " + Thread.currentThread());
		CompletableFuture<Integer> completableFuture = completableFuture(transaction); 
		
		Thread.sleep(1000);
		completableFuture.thenAccept(balance -> display(balance));
		Thread.sleep(1000);
	}
	
	
	
	
	
	
	private static CompletableFuture<Integer> completableFuture(Transaction transaction) {
		System.out.println("Insite CompletableFuture() -> " + Thread.currentThread());
		return CompletableFuture.supplyAsync(() -> transaction.getBalance()); 
	}
	
	
	
	private static void singleThreadedModel() {
		Transaction transaction = new Transaction(); 
		System.out.println("I'm in SingleThreadModel() : Thread: " + Thread.currentThread());
		display(transaction.getBalance()); 
	}

	private static void display(int balance) {
		System.out.println("Balance is : " + balance);
		System.out.println("I'm in display() : Thread: " + Thread.currentThread());		
	}
	
	
	
	
	
}
