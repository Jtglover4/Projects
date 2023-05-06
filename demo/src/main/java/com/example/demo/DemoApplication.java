package com.example.demo;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	private static final String BASE_URL = "http://localhost:8080/";

	// Map to store the shortened URLs and their corresponding original URLs
	private static final Map<String, String> urlMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Endpoint to encode a URL to a shortened URL
	@GetMapping("/encode")
	public String encodeUrl(@RequestParam("url") String url) {
		// Generate a Base64-encoded string from the original URL
		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes());

		// Add the shortened URL and its original URL to the map
		urlMap.put(encodedUrl, url);

		// Return the shortened URL as a JSON response
		return "{\"shortenedUrl\": \"" + BASE_URL + encodedUrl + "\"}";
	}

	// Endpoint to decode a shortened URL to its original URL
	@GetMapping("/decode")
	public String decodeUrl(@RequestParam("shortenedUrl") String shortenedUrl) {
		// Get the original URL from the map using the shortened URL as the key
		String originalUrl = urlMap.get(shortenedUrl);

		// Return the original URL as a JSON response
		return "{\"originalUrl\": \"" + originalUrl + "\"}";
	}
}
