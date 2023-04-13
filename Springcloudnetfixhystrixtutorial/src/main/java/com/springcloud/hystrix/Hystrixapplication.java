package com.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication		// This annotation boostraps and auto-configure the application.
@EnableCircuitBreaker		// This annotation enables the circuit breaker for the microservice.
public class Hystrixapplication {

	public static void main(String[] args) {
		SpringApplication.run(Hystrixapplication.class, args);
	}
}