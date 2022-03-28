package com.customer.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
		customerService.registerCustomer(customerRegistrationRequest);

	}
}
