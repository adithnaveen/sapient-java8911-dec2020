package com.sapient.java11features;

import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflatDemo {
	public static void main(String[] args) throws UnsupportedEncodingException, DataFormatException {
		String message ="This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test This is for Test "; 
	
		System.out.println("Original Content Length : " + message.length() );
		
	
		byte[] bytes = message.getBytes("UTF-8"); 
		
		
		byte [] output = new byte[1024]; 
		
		Deflater deflater = new Deflater(); 
		deflater.setInput(bytes); 
		deflater.finish(); 
		
		int compressedDataLength = deflater.deflate(output); 
		deflater.end(); 
		
		System.out.println("Compressed Message Length " + compressedDataLength);
	
		// decompress the bytes 
		Inflater inflater = new Inflater(); 
		inflater.setInput(output, 0, compressedDataLength);
		byte [] result = new byte[1024]; 
		int resultLenght = inflater.inflate(result); 
		inflater.end(); 
		
		System.out.println("Result Lenght is : " + resultLenght);
	}
}








