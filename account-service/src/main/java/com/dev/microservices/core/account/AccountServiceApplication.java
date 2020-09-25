package com.dev.microservices.core.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String... args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
}