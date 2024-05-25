package com.ecommerce.bean;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Merchant {
	private int merchantAccountNo;
	private String businessName;
	private LocalDate establishedDate;
	private String businessType;
	private String registeredOwnerName;
	private String licenseNo;
	private String contactNo;
	private LocalDate openedDate;
	private String status;

}
