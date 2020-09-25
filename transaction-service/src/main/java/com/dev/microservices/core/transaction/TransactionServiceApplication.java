package com.dev.microservices.core.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class TransactionServiceApplication {

	public static void main(String... args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}
}