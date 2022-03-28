package com.fraud.application;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {

	@Id
	@SequenceGenerator(name = "Fraud_id_generator ", sequenceName = "Fraud_id_generator")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Fraud_id_generator")
	private Integer id;

	private Boolean isFraudster;

	private LocalDateTime createdAt;
	private Integer customerId;

}
