package com.wlbn.errorhandlingwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErrorHandlingWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorHandlingWebFluxApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println("Start calling your API now.");
		};
	}

}
