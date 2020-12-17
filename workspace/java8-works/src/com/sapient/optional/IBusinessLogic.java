package com.sapient.optional;

import java.util.List;
import java.util.Optional;

public interface IBusinessLogic {
	List<String> getTravelPlaces(String state); 
	
	Optional<String> getCapitalCity(String state) ; 
}
