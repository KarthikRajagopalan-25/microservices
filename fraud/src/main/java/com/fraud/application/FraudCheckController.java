package com.fraud.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fraud-check")
public class FraudCheckController {

	private final FraudCheckService fraudCheckService;

	@GetMapping("/{customerId}")
	public FraudCheckResponse isFraudCustomer(@PathVariable Integer customerId) {

		boolean isFraudulentCustomer = fraudCheckService.isFraudlentCustomer(customerId);

		return FraudCheckResponse.builder().isFraudulentCustomer(isFraudulentCustomer).build();
	}
}
