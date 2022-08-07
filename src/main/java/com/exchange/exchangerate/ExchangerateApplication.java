package com.exchange.exchangerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ExchangerateApplication {

	@Bean
	public RestTemplate restTemplateCreator(){
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExchangerateApplication.class, args);
	}

}
