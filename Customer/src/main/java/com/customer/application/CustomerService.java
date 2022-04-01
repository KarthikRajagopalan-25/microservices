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

		customerRepository.saveAndFlush(customer);
		FraudCheckResponse fraudCheckResponse = null;
		 fraudCheckResponse = restTemplate.getForObject(
				"http://FRAUD/api/v1/fraud-check/{customerId}",
				FraudCheckResponse.class,
				customer.getId()
			);
		
	//FraudCheckResponse fraudCheckResponse = fraudCheckClient.isFraudCustomer(customer.getId());
		
		if(fraudCheckResponse.isFraudulentCustomer()) {
			throw new IllegalStateException("Fradulent Customer");
		}
		
		
	}

}
