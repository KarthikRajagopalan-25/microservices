package com.fraud.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudCheckResponse {

	
	private boolean isFraudulentCustomer;
}
