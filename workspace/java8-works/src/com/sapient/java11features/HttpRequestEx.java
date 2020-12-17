package com.sapient.java11features;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpRequestEx {

	
	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
//		httpGetRequest();
		httpPostRequest();
	}
	
	private static void httpGetRequest() throws IOException, InterruptedException {
		String URL ="https://jsonplaceholder.typicode.com/todos/1"; 
		
		HttpClient client = HttpClient.newHttpClient(); 
		
		HttpRequest req = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_1_1)
				.uri(URI.create(URL))
//				.headers("Accept-Encoding", "gzip, deflate")
				.build(); 
				
		HttpResponse<String> response = client.send(req, BodyHandlers.ofString()); 
		String responseBody = response.body(); 
		int statusCode = response.statusCode(); 
		System.out.println("Response Body " + responseBody);
		System.out.println("Status Code : " + statusCode);
	}
	
	private static void httpPostRequest() throws URISyntaxException, IOException, InterruptedException {
		
		String URI ="https://jsonplaceholder.typicode.com/posts"; 
		HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build(); 
		
		HttpRequest request  = HttpRequest.newBuilder(new URI(URI)).
					POST(BodyPublishers.ofString("{sample:sample}")).build(); 
		
		HttpResponse<String> send = client.send(request, BodyHandlers.ofString()); 
		
		System.out.println("Response Body :" + send.body());
		System.out.println("Status Code :" + send.statusCode());		
	}
	
}












