package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yatinbatra
 *
 */
@SpringBootApplication	// This annotation boostraps and auto-configure the application.
@EnableDiscoveryClient	// This annotation lists the application on the eureka server.
@EnableZuulProxy		// This annotation enables the zuul gateway.

// Application url - localhost:9292/feign/getGreetings/en
public class Myzuulgateway {

	public static void main(String[] args) {
		SpringApplication.run(Myzuulgateway.class, args);
	}
}