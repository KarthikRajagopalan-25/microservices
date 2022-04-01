package com.fraud.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class FraudCheckApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(FraudCheckApplication.class, args);
	}

}
