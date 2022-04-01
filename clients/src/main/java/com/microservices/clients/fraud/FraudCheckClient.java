package com.microservices.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="fraud")
public interface FraudCheckClient {

	@GetMapping("/api/v1/fraud-check/{customerId}")
	public FraudCheckResponse isFraudCustomer(@PathVariable Integer customerId);
}
