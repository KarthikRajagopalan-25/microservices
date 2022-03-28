package com.customer.application;

import javax.annotation.Generated;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	@SequenceGenerator(
			name ="Customer_ID_genrator",
			sequenceName = "Customer_generator"
			)
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator = "Customer_ID_genrator"
			)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String email;
	}
