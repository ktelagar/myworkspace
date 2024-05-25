package com.exceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
public class MerchantPaymentRequest {
	private String fromUpiID;
	private String toUpiID;
	private double amount;
}
