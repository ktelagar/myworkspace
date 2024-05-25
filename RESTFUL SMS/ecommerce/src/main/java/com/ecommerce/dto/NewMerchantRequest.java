package com.ecommerce.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class NewMerchantRequest {
	private String businessName;
	private LocalDate establishedDate;
	private String businessType;
	private String registeredOwnerName;
	private String licenseNo;
	private String contactNo;
}
