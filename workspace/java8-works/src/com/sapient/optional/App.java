package com.sapient.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class App {

	static List<Place> places = Arrays.asList(
			new Place("Karnataka",
					Optional.of("Bengaluru") , Arrays.asList("Mysuru", "Mangaluru", "Hubballi")),
			new Place("Rajastan",Optional.of("Jaipur" ) , Arrays.asList("Jodhpur", "Kota", "Bikaner")),
			new Place("Andra", Optional.of("Hyderabad" ) , Arrays.asList("Vizag", "Anathpura")), 
			new Place("Nauru", Optional.empty(), null));

	static IBusinessLogic service = null;

	public static void main(String[] args) {
		service = new BusinessLogic(places);

		String state = "Karnataka";
		System.out.println("Capital of Karnataka : " + service.getCapitalCity(state));
//		System.out.println("--------------------Old Way --------------------------");

//		 oldWay(service, state);

		System.out.println("-------------------- With Optionals --------------------------");
//		withOptionals(service, state);
//		withOptionals1(places.get(0).getPlaceToVisit());

		
		checkCapital("Nauru");
		
	}

	private static void withOptionals(IBusinessLogic service, String state) {
		// either we can get the new arraylist or throw an exception

//		List<String> listOfCities = Optional.ofNullable(service.getTravelPlaces(state)).orElseGet(ArrayList :: new);
		List<String> listOfCities = Optional.ofNullable(service.getTravelPlaces(state)).orElseThrow();
		listOfCities.forEach(System.out::println);
	}

	private static void oldWay(IBusinessLogic service, String state) {
		System.out.println("Travel Places in State " + state);

		List<String> listOfCities = service.getTravelPlaces(state);

		if (listOfCities != null) {
			listOfCities.forEach(System.out::println);
		} else {
			System.out.println("No Cities Found to Travel... ");
			listOfCities = new ArrayList<String>();
		}
	}

	private static void withOptionals1(List<String> places) {

		for (String temp : places) {
			Function<String, String> cityWith7Chars = (String s) -> s.length() > 8 ? s : null;
			Function<String, Integer> cityHasPattern = s -> s.indexOf("a");
			String valid = cityWith7Chars.apply(temp);

			Optional<String> customOptional = Optional.ofNullable(cityWith7Chars.apply(temp));

			// version 1.0 
			// java 8 
			if (customOptional.isPresent()) {
				System.out.println(customOptional.get()); 
			} else {
				System.out.println("Value Not Present");
			}
			
			// version 2.0 
			customOptional.ifPresent(System.out::println);
			System.out.println(customOptional.orElse("Value Not Present"));
			

			Optional chainingOptionals = Optional.ofNullable(cityWith7Chars.apply(temp)).map(cityHasPattern); 
			chainingOptionals.ifPresent(t ->  System.out.println("*****  : " + t));
			chainingOptionals.orElse("Value Not Found... "); 
			
			
			System.out.println("From java 9 ");
			
			customOptional.ifPresentOrElse(System.out :: println, () -> {
				System.out.println("No Data Found.... ");
			});
		}

	}

	private static void checkCapital(String state ) {
//		Optional.of(service.getCapitalCity(state)).ifPresentOrElse(System.out:: println,
//				() -> {
//					System.out.println("Capital Not there for " + state);
//				});
		
		service.getCapitalCity(state).ifPresentOrElse(System.out:: println,
				() -> {
					System.out.println("Capital Not there for " + state);
				});
		 
	}
}
