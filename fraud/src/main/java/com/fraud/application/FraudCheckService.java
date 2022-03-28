package com.fraud.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class FraudCheckService {
	
	private final FraudCheckRepository fraudCheckRepository;
	
	public boolean isFraudlentCustomer (@PathVariable  Integer customerId) {
		
		fraudCheckRepository.save(FraudCheckHistory.builder().customerId(customerId).isFraudster(false).createdAt(LocalDateTime.now()).build());
		
		return false;
		
	}

}
