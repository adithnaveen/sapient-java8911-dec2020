package com.sapient.function;

import java.util.HashSet;
import java.util.Set;

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