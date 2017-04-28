package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringTestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/check")
	public String check(){
		System.out.println("app "+ restTemplate);
		return restTemplate.getForEntity("http://services.groupkt.com/country/get/all", String.class).getBody();
	}
	
	@Bean
	public RestTemplate createREst() {
		return new RestTemplate();
	}
}
