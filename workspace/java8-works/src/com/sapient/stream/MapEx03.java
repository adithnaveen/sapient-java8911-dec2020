package com.sapient.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


// Person(
public class MapEx03 {
	public static void main(String[] args) {
		
		List<Person> list = Arrays.asList(
				new Person(101, "Tarun", "male"), 
				new Person(45, "Rohit", "male"), 
				new Person(66, "Ankit", "male" ), 
				new Person(23, "Savitha", "female"), 
				new Person(88, "Prina", "female") 
			); 
		
		Function<Person, Person> modifiedPersons = (p) ->  {
			
			Person p1 = new Person(); 
			
			if(p.getGender().equals("male")) {
				p1.setpName("Mr. " + p.getpName());
			}else  {
				p1.setpName("Ms/Mrs. " + p.getpName());
			}
			
			p1.setpId(p.getpId());
			p1.setGender(p.getGender());
			
			return p1;
		}; 
		
		List<Person> newPersonList = 
				
				list.stream()
				.map(modifiedPersons)
				.collect(Collectors.toList()); 
		
		newPersonList.forEach(System.out :: println);
		
		
	}
}
