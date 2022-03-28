package com.customer.application;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
		Customer customer = Customer.builder().firstName(customerRegistrationRequest.firstName())
				 .lastName(customerRegistrationRequest.lastName())
				 .email(customerRegistrationRequest.email()).build();
		
		customerRepository.save(customer);
		
	}

}
