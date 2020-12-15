package com.sapient.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StreamEx01 {
	public static void main(String[] args) throws IOException {
		try (
			FileWriter fw1 = new FileWriter("sample.txt"); 
			BufferedWriter bw = new BufferedWriter(fw1);
		) {
			
			bw.write("This is in java 8 example");
			bw.newLine();
			bw.write("another line for testing");
			bw.newLine(); 
		}
		
		System.out.println("Data Written... ");
		
	}
}
