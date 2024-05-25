package com.ecommerce.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewMerchantResponse {
	private int merchantAccountNo;
	private LocalDate openedDate;
	private String status;
}
