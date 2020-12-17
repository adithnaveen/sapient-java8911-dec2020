package com.sapient.optional;

import java.util.List;
import java.util.Optional;

public class Place {
	private String state; 
	private Optional<String> capital; 
	private List<String> placeToVisit;
	
	public Place() {}

	public Place(String state, Optional<String> capital, List<String> placeToVisit) {
		super();
		this.state = state;
		this.capital = capital;
		this.placeToVisit = placeToVisit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Optional<String> getCapital() {
		return capital;
	}

	public void setCapital(Optional<String> capital) {
		this.capital = capital;
	}

	public List<String> getPlaceToVisit() {
		return placeToVisit;
	}

	public void setPlaceToVisit(List<String> placeToVisit) {
		this.placeToVisit = placeToVisit;
	}

	@Override
	public String toString() {
		return "Place [state=" + state + ", capital=" + capital + ", placeToVisit=" + placeToVisit + "]";
	}
	 
	
}
