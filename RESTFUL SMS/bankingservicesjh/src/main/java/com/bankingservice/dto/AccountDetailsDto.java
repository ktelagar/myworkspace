package com.bankingservice.dto;

public class AccountDetailsDto {
	private String accountNo;
	private String accountHolderName;
	private String accountType;
	private String registeredMobileNo;
	private String registeredEmailAddress;
	private String ifscCode;
	private String branch;
	private double balance;
	private String status;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRegisteredMobileNo() {
		return registeredMobileNo;
	}

	public void setRegisteredMobileNo(String registeredMobileNo) {
		this.registeredMobileNo = registeredMobileNo;
	}

	public String getRegisteredEmailAddress() {
		return registeredEmailAddress;
	}

	public void setRegisteredEmailAddress(String registeredEmailAddress) {
		this.registeredEmailAddress = registeredEmailAddress;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
