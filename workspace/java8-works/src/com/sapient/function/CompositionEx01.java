package com.sapient.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// function composition 
public class CompositionEx01 {
	
	private static class Employee {
		public final String name; 
		public final Integer age; 
		public final String jobTitle; 
		public final Float salary;
		
		
		public Employee(String name, Integer age, String jobTitle, Float salary) {
			super();
			this.name = name;
			this.age = age;
			this.jobTitle = jobTitle;
			this.salary = salary;
		}


		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", jobTitle=" + jobTitle + ", salary=" + salary + "]";
		}
	}
	
	public static void main(String[] args) {
		Function<Integer, Integer> timesTwo = x -> x*2; 
		Function<Integer, Integer> minusOne = x -> x -1; 
		
//														20 -1 
		Function<Integer, Integer> timesTwoMinusOne = timesTwo.andThen(minusOne); 
		System.out.println("timesTwoMinusOne: "+timesTwoMinusOne.apply(10));
		
//														10-1 =9 *2  
		Function<Integer, Integer> timesTwoMinusOne1 = timesTwo.compose(minusOne); 
		System.out.println("timesTwoMinusOne1: " + timesTwoMinusOne1.apply(10));
		
		
		//////////////////////////////////////////////////////////////////////////
		
		List<Employee> employees = 
		Arrays.asList(
				new Employee("Ananth", 24, "Developer", 1234f), 
				new Employee("Nirmamidi", 25, "Tester", 2233f), 
				new Employee("Savitha", 24, "Developer", 1212f), 
				new Employee("Amandeep", 23, "Manager", 8834f), 
				new Employee("Tarun", 30, "Developer", 1234f) 
				); 
		
		// any number of functions 
		Function<Employee, String> getName = employee -> employee.name; 
		Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString(); 
		Function<String, String> toUpper = str -> str.toUpperCase(); 

		
		
		Function<Employee, String> getReversedUpperCasedName = 
				getName.andThen(reverse).andThen(toUpper); 
		
		List<String> result = employees
			.stream()
			.map(getReversedUpperCasedName)
			.collect(Collectors.toList()); 
		
		
		result.forEach(System.out :: println);
		
	}
}





