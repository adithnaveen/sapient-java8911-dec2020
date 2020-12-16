package com.sapient.lambdas;

// if you mark the interface as functional interface then 
// you can have 1 abstract method 


@FunctionalInterface
interface Executable{
	int execute(int a, int b);
} 

@FunctionalInterface
interface StringExecutable {
	String stringExecute(String a, String b); 
}

class Runner {
	// or more parameters 
	public void run(Executable e) {
		System.out.println("Executable block called... ");
		int val1 = 100; 
		int val2 = 200; 
		int retValue = e.execute(val1, val2);
		System.out.println("Retured Value is : " + retValue);
	}
	
	public void run(StringExecutable e) {
		System.out.println("StringExecutable block called... ");
		String retString = e.stringExecute("Hello", "World"); 
		System.out.println("Concat of String "+ retString);
	}
}

public class LambdaEx02 {
	public static void main(String[] args) {
		
		Runner runner = new Runner(); 
		
		
		runner.run(new Executable() {
			
			@Override
			public int execute(int a, int b) {
				System.out.println("In execute block... ");
				return a+b;
			}
		});
		
		Executable ex = (a, b) -> a + b; 
		
		
		
		System.out.println("---- in labda way--- ");
		System.out.println(ex.execute(20, 30));  
		
		Object ex1= (Executable) (a, b) -> a + b; 
		
		System.out.println("Computer result stored in Object " 
					+ ((Executable)ex1).execute(100, 200)); ;
		
		 	
		// string part TODO  
		
		
		
		
		
		
	}
}
