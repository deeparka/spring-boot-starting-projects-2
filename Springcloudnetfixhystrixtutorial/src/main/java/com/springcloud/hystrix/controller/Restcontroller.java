package com.springcloud.hystrix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.hystrix.model.Product;

@RestController
@RequestMapping(value= "/api")
public class Restcontroller {

	static Faker faker= new Faker();

	@GetMapping(value= "/product")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<Product> getProduct() {

		Product item = new Product();
		item.setId(1001);
		item.setName(faker.commerce().productName());
		item.setDepartment(faker.commerce().department());
		item.setPrice(faker.commerce().price());

		// Throwing an error for illustrating that the microservice is down and the fallback method will be called for sending a dummy response.
		if(item.getId() == 1001) {
			throw new RuntimeException();
		}

		return new ResponseEntity<Product>(item, HttpStatus.OK);
	}

	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command
	// using the hystrix-command annotation.
	public ResponseEntity<Product> defaultResponse() {
		System.out.println("You are seeing this fallback response because the underlying microservice is down or has thrown an error!");

		Product fallbackItem = new Product();
		fallbackItem.setId(90009);
		fallbackItem.setName("Dummy Name");
		fallbackItem.setDepartment("Dummy Department");
		fallbackItem.setPrice("0.00");

		return new ResponseEntity<Product>(fallbackItem, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}