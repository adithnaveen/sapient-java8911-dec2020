package com.sapient.stream;

public class Person {
	private int pId;
	private String pName;
	private String gender; 
	
	public Person() {
	}
	public Person(int pId, String pName, String gender) {
		this.pId = pId; 
		this.pName = pName; 
		this.setGender(gender); 
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	 
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", gender=" + gender + "]";
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	} 
}
