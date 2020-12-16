package com.sapient.function;

import java.util.Set;

class CombineDeveloper {
	private Developer firstDeveloper;
	private Developer secondDeveloper; 
	private Set<String> languages;
	
	
	
	public Developer getFirstDeveloper() {
		return firstDeveloper;
	}
	public void setFirstDeveloper(Developer firstDeveloper) {
		this.firstDeveloper = firstDeveloper;
	}
	public Developer getSecondDeveloper() {
		return secondDeveloper;
	}
	public void setSecondDeveloper(Developer secondDeveloper) {
		this.secondDeveloper = secondDeveloper;
	}
	public Set<String> getLanguages() {
		return languages;
	}
	public void setLanguages(Set<String> languages) {
		this.languages = languages;
	}
	@Override
	public String toString() {
		return "CombineDeveloper [firstDeveloper=" + firstDeveloper + ", secondDeveloper=" + secondDeveloper
				+ ", languages=" + languages + "]";
	}
	public CombineDeveloper(Developer firstDeveloper, Developer secondDeveloper) {
		super();
		this.firstDeveloper = firstDeveloper;
		this.secondDeveloper = secondDeveloper;
	}
	 
	
	
	
}