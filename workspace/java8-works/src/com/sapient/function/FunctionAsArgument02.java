package com.sapient.function;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public class FunctionAsArgument02 {
	
	public static CombineDeveloper combine (Developer developer1, Developer developer2) {
		
		CombineDeveloper cd = new CombineDeveloper(developer1, developer2);
		
			List<Developer> developers = Arrays.asList(developer1, developer2);
			
			Set<String> languages = developers.stream().map(Developer :: getLanguages)
					.flatMap(Collection :: stream) 
					.distinct() 
					.collect(Collectors.toSet()); 
			
			cd.setLanguages(languages);
		return cd; 
	}
	
	
	public static CombineDeveloper combineDevelopers 
		(
				BiFunction<Developer, Developer, CombineDeveloper> combineFunction, 
				Developer developer1, 
				Developer developer2 
				) {
		return combineFunction.apply (developer1, developer2); 
	}
	
	public static void main(String[] args) {
		Developer prathibha = new Developer("Pratibha");

		prathibha.add("Java");
		prathibha.add("React");
		prathibha.add("C++");

		Developer rohit = new Developer("Rohit");

		rohit.add("Angular");
		rohit.add("React");

		System.out.println(combineDevelopers(FunctionAsArgument02:: combine, prathibha, rohit));
	}
}












