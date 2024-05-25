package com.restfulcache.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
	private String accountNo;
	private String accountHolderName;
	private String accountType;
	private String ifscCode;
	private String branch;
	private String mobileNo;
	private String emailAddress;
	private double balance;

}
