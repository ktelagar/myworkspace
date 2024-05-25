package com.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UpdateMerchantRequest {
	private int merchantAccountNo;
	private String businessName;
	private String registeredOwnerName;
	private String contactNo;
}
