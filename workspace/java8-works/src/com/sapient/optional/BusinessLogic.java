package com.sapient.optional;

import java.util.List;
import java.util.Optional;

public class BusinessLogic implements IBusinessLogic{

	private List<Place> places; 
	
	public BusinessLogic(List<Place> places) {
		this.places = places; 
	}
	
	@Override
	public List<String> getTravelPlaces(String state) {
		return findTravelPlace(state).getPlaceToVisit(); 
	}

	private Place findTravelPlace(String state) {
		for(Place temp : places) {
			if(temp.getState().equals(state)) {
				return temp; 
			}
		}
		// to be converted to optional 
		return null; 
		
	}

	@Override
	public Optional<String> getCapitalCity(String state) {
		return findTravelPlace(state).getCapital(); 
	}
	
}
