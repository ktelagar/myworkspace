package com.bankingservice.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.json.bind.annotation.JsonbDateFormat;

public class OpenAccountDto {
	private String firstName;
	private String lastName;
	@JsonbDateFormat(value = "yyyy-MM-dd")
	private LocalDate dob;
	private String gender;
	private String emailAddress;
	private String mobileNo;
	private String identityType;
	private String identityNo;
	private String panNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Override
	public String toString() {
		return "OpenAccountDto [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender="
				+ gender + ", emailAddress=" + emailAddress + ", mobileNo=" + mobileNo + ", identityType="
				+ identityType + ", identityNo=" + identityNo + ", panNo=" + panNo + "]";
	}

}
