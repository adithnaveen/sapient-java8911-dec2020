package com.sapient.stream;

import java.util.Arrays;

// program to convert all elements of 2 dim array to double 
public class MapEx02 {
	public static void main(String[] args) {
		Integer[][] myArray = new Integer[][] { 
			{ 1, 2, 3, 4 }, 
			{ 4, 5, 6 }, 
			{ 10, 20, 30 } 
		};
		
		
		double [][] doubleArray = 
		Arrays.stream(myArray)
			.map(
					// the pArray will take the array, which is 1 dimensional 
					// which is each row  ({ 1, 2, 3, 4 }  -> 1, 2, 3, 4 -> [1.0, 2.0, 3.0, 4.0]
					pArray -> Arrays.stream(pArray)
					.mapToDouble(d -> d.doubleValue())
					.toArray()
					
					
				).toArray(size -> new double [size][]); 
			
		
		for(double [] temp : doubleArray) {
			System.out.println(Arrays.toString(temp));
		}
					
	}
}
