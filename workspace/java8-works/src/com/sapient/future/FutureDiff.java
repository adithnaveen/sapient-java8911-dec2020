package com.sapient.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class FutureDiff {
	public static void main(String[] args)
				throws InterruptedException, ExecutionException {

		RunnableFuture<String> future = new FutureTask<String>(() -> {
			System.out.println("Thread Inside : " + Thread.currentThread());
			Thread.sleep(1000);
			return "Hello";
		});
		new Thread(future).start();

		System.out.println("i'm in main... ");
		System.out.println(future.get());
		System.out.println("I'm last... ");
	}
}
