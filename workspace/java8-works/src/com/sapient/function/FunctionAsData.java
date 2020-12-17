package com.sapient.function;

// we can get the data in java8 from the function (Function as data) 

public class FunctionAsData {
	
	private static class Dev  {
		private String name;
		private Integer age; 
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public Dev(String name, Integer age) {
			this.name = name;
			this.setAge(age); 
		}
	
		public Integer getAge() {
			return age;
		}
	
		public void setAge(Integer age) {
			this.age = age;
		}
	}

	 // Fake or Real 
	
	 static class DataLoader {
		public final NoArgFunction<Dev> loadDeveloepr; 
		
		public DataLoader(Boolean isReal) {
			this.loadDeveloepr = isReal ? this :: loadDevReal : this :: loadDevFake; 
		}
		
		
		private Dev loadDevReal() {
			System.out.println("Loading Dev.... ");
			return new Dev("Real Dev", 30); 
		}
		private Dev loadDevFake() {
			System.out.println("Returning Fake Dev...");
			return new Dev("Fake Dev", 101); 
		}
		
	}
	
	
	public static void main(String[] args) {
		final Boolean IS_REAL = false; 
		
		DataLoader dataLoader = new DataLoader(IS_REAL); 
		System.out.println(dataLoader.loadDeveloepr.apply());
		
	}
	

}















