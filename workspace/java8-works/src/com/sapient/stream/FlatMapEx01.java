package com.sapient.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Developer {
	private String name;
	private Set<String> languages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Developer(String name) {
		this.languages  = new HashSet<String>();  
		this.name = name;
	}

	public Set<String> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<String> languages) {
		this.languages = languages;
	}

	public void add(String language) {
		this.languages.add(language);
	}

}

public class FlatMapEx01 {
	public static void main(String[] args) {
		Developer prathibha = new Developer("Pratibha");

		prathibha.add("Java");
		prathibha.add("React");
		prathibha.add("C++");

		Developer rohit = new Developer("Pratibha");

		rohit.add("Angular");
		rohit.add("React");

		Developer rahul = new Developer("Pratibha");

		rahul.add("Closure");
		rahul.add("Go");
		rahul.add("C++");

		
		System.out.println("Programming Languages in the team : ");
		
		List<Developer> developerTeam = new ArrayList<Developer>(); 
		
		developerTeam.add(prathibha);
		developerTeam.add(rohit);
		developerTeam.add(rahul);
		
		
		developerTeam.stream()
			.map(Developer :: getLanguages)
			.flatMap(Collection :: stream) // the mapped languages get the  stream of value/s as string 
			.distinct() 
			.collect(Collectors.toList())
			.forEach(System.out ::println); 
			 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
