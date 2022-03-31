package com.customer.application;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final RestTemplate restTemplate ;

	public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
		Customer customer = Customer.builder().firstName(customerRegistrationRequest.firstName())
				 .lastName(customerRegistrationRequest.lastName())
				 .email(customerRegistrationRequest.email()).build();
		FraudCheckResponse fraudCheckResponse = null;
		customerRepository.saveAndFlush(customer);
		 fraudCheckResponse = restTemplate.getForObject(
				"http://localhost:8081/api/v1/fraud-check/{customerId}",
				FraudCheckResponse.class,
				customer.getId()
			);
		
		if(fraudCheckResponse.isFraudulentCustomer()) {
			throw new IllegalStateException("Fradulent Customer");
		}
		
		
	}

}
